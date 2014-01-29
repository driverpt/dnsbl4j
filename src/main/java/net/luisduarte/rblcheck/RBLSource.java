package net.luisduarte.rblcheck;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class RBLSource implements IRBLSource {
    protected Map<String, String> errorCodeContainer;

    private String name;
    private String fqdn;

    protected RBLSource(String name, String fqdn) {
        this.name = name;
        this.fqdn = fqdn;
        errorCodeContainer = new HashMap<String, String>();
        loadErrorCodes(errorCodeContainer);
    }

    public abstract void loadErrorCodes(Map<String, String> container);

    public RBLError convert(String result) {
        return new RBLError(this, result, errorCodeContainer.get(result));
    }

    public String getHostname() {
        return fqdn;
    }

    public String getProviderName() {
        return name;
    }

    public Collection<RBLError> check(InetAddress address) {

        byte[] byteAddress = address.getAddress();
        byteAddress = IPUtils.reverseIPAddress(byteAddress);
        String reversedIpAddress = IPUtils.byteArrayToString(byteAddress);
        List<RBLError> result = new LinkedList<RBLError>();
        try {
            List<String> lookupResults = doLookup(reversedIpAddress + "." + fqdn);
            for(String lookupResult : lookupResults) {
                result.add(convert(lookupResult));
            }
            return result;
        } catch (NamingException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static List<String> doLookup(String hostName) throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put("java.naming.factory.initial",
                "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext(env);
        Attributes attrs = null;

        try {
            attrs = ictx.getAttributes(hostName, new String[] { "A" });
        } catch(NamingException e){
            return Collections.emptyList();
        }

        Attribute attr = attrs.get("A");
        if (attr == null) {
            return Collections.emptyList();
        }

        List<String> results = new LinkedList<String>();

        NamingEnumeration<?> enumeration = attr.getAll();

        while(enumeration.hasMore()) {
            results.add(enumeration.next().toString());
        }

        return results;
    }
}
