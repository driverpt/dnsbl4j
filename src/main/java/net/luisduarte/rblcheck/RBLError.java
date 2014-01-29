package net.luisduarte.rblcheck;

public class RBLError {
    private RBLSource source;
    private String returnCode;
    private String returnDescription;

    public RBLError(RBLSource source, String returnCode, String returnDescription) {
        this.source = source;
        this.returnCode = returnCode;
        this.returnDescription = returnDescription;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnDescription() {
        return returnDescription;
    }

    public RBLSource getSource() {
        return source;
    }
}
