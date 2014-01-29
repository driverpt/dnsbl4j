package net.luisduarte.rblcheck;

import java.net.InetAddress;

public class IPUtils {
    private IPUtils(){}

    public static byte[] reverseIPAddress(byte[] ip) {
        return reverseByteArray(ip);
    }

    public static String byteArrayToString(byte[] array) {
        // Since we bytes in Java are unsigned, we need to "upcast" them to int
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] & 0xFF);
            builder.append(".");
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static InetAddress parseIPAddress(String ip) {
        if( ip == null || ip.isEmpty() ) {
            throw new IllegalArgumentException("No IP Provided");
        }

        try {
            return InetAddress.getByName(ip);
        } catch(Exception e) {
            throw new IllegalArgumentException("Invalid IP Provided");
        }
    }

    public static byte[] reverseByteArray(byte[] a) {
        for(int i = 0; i < a.length / 2; i++){
            byte temp = a[i]; // swap using temporary storage
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }

        return a;
    }
}
