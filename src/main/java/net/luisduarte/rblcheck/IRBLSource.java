package net.luisduarte.rblcheck;

import java.net.InetAddress;
import java.util.Collection;

public interface IRBLSource {
    public RBLError convert(String result);
    public String getHostname();
    public String getProviderName();
    public Collection<RBLError> check(InetAddress address);
}
