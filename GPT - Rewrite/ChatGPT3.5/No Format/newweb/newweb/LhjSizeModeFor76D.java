package com.newweb.vo;

public class LhjSizeModeFor76D implements LhjSizemode {

    private String type;
    private double sxhLength;
    private int sxhCount;
    // ... (other fields)

    // Constructors
    public LhjSizeModeFor76D(String type, double sxhLength, int sxhCount, /* other parameters */) {
        this.type = type;
        this.sxhLength = sxhLength;
        this.sxhCount = sxhCount;
        // initialize other fields
    }

    // Getters (no setters for immutability)
    public String getType() {
        return type;
    }

    public double getSxhLength() {
        return sxhLength;
    }

    public int getSxhCount() {
        return sxhCount;
    }

    // ... (other getters)

    // toString() method for better readability
    @Override
    public String toString() {
        return "LhjSizeModeFor76D{" +
                "type='" + type + '\'' +
                ", sxhLength=" + sxhLength +
                ", sxhCount=" + sxhCount +
                // ... (other fields)
                '}';
    }
}
