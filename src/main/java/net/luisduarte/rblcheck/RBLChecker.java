package net.luisduarte.rblcheck;

import java.net.InetAddress;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class RBLChecker {
    private List<RBLSource> sources;

    public RBLChecker() {
        this.sources = new LinkedList<RBLSource>();
    }

    public static RBLChecker newInstance() {
        return new RBLChecker();
    }

    public RBLChecker withSource(RBLSource source) {
        sources.add(source);
        return this;
    }

    public boolean removeSource(RBLSource source) {
        for(RBLSource src : sources){
            if( src.getProviderName().equals(source.getHostname()) ) {
                return sources.remove(src);
            }
        }
        return false;
    }

    // Return a Collection or a Map ?
    public Collection<RBLError> checkIP(String ip) {
        InetAddress address = IPUtils.parseIPAddress(ip);
        List<RBLError> errors = new LinkedList<RBLError>();
        for( RBLSource source : sources ) {
            errors.addAll(source.check(address));
        }

        return errors;
    }

    public Collection<RBLError> checkIP(byte[] ip) {
        return checkIP(IPUtils.byteArrayToString(ip));
    }
}
