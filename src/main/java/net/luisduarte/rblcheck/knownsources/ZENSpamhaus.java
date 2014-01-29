package net.luisduarte.rblcheck.knownsources;

import net.luisduarte.rblcheck.RBLSource;

import java.util.Map;

public class ZENSpamhaus extends RBLSource {

	public ZENSpamhaus() {
		super("Spamhaus", "zen.spamhaus.org");
	}

    @Override
    public void loadErrorCodes(Map<String, String> container) {
        container.put("127.0.0.2", "Spamhaus SBL Data");
        container.put("127.0.0.3", "Spamhaus SBL CSS Data");
        container.put("127.0.0.4", "XBL CBL Data");
        container.put("127.0.0.5", "XBL Customized NJABL Data");
        container.put("127.0.0.10", "PBL ISP Maintained");
        container.put("127.0.0.11", "PBL Spamhaus Maintained");
    }
}
