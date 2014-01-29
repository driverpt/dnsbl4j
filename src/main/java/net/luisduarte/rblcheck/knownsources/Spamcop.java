package net.luisduarte.rblcheck.knownsources;

import net.luisduarte.rblcheck.RBLSource;

import java.util.Map;

public class Spamcop extends RBLSource {

    public Spamcop() {
        super("Spamcop", "bl.spamcop.net");
    }

    @Override
    public void loadErrorCodes(Map<String, String> container) {
        container.put("127.0.0.2", "Spamcop Listed");
    }
}
