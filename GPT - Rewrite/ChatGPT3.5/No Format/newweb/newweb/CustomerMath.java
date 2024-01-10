package com.newweb.util;

import java.math.BigDecimal;

public class CustomerMath {

    // Default division scale
    private static final int DEFAULT_DIVISION_SCALE = 10;

    // This class cannot be instantiated
    private CustomerMath() {
        // No implementation needed
    }

    /**
     * Provides precise addition.
     *
     * @param v1 the first operand
     * @param v2 the second operand
     * @return the sum of the two operands
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * Provides precise subtraction.
     *
     * @param v1 the minuend
     * @param v2 the subtrahend
     * @return the difference between the minuend and subtrahend
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * Provides precise multiplication.
     *
     * @param v1 the first factor
     * @param v2 the second factor
     * @return the product of the two factors
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * Provides (relatively) precise division. Rounds to 10 decimal places and performs rounding if necessary.
     *
     * @param v1 the dividend
     * @param v2 the divisor
     * @return the quotient of the two numbers
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEFAULT_DIVISION_SCALE);
    }

    /**
     * Provides (relatively) precise division. Rounds to the specified number of decimal places and performs rounding if necessary.
     *
     * @param v1    the dividend
     * @param v2    the divisor
     * @param scale the number of decimal places to round to
     * @return the quotient of the two numbers
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a non-negative integer");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Provides precise rounding to the specified number of decimal places.
     *
     * @param v     the number to round
     * @param scale the number of decimal places to round to
     * @return the rounded number
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a non-negative integer");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
