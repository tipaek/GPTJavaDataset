package com.newweb.vo;

public class LhjSizeModeFor728 implements LhjSizemode {

    private String type;
    private double sxhLength;
    private int sxhCount;
    private double bfLength;
    private int bfCount;
    // ... (other fields)

    public LhjSizeModeFor728(String type, double sxhLength, int sxhCount, double bfLength, int bfCount, /* other parameters */) {
        this.type = type;
        this.sxhLength = sxhLength;
        this.sxhCount = sxhCount;
        this.bfLength = bfLength;
        this.bfCount = bfCount;
        // initialize other fields
    }

    // Getters (no setters for immutability)

    // ... (other getters)

    @Override
    public String toString() {
        return "LhjSizeModeFor728{" +
                "type='" + type + '\'' +
                ", sxhLength=" + sxhLength +
                ", sxhCount=" + sxhCount +
                // ... (other fields)
                '}';
    }
}
