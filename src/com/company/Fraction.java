package com.company;

public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction(int numerator,int denominator) {
        try {
            this.numerator = numerator;
            this.denominator = denominator;
            check(numerator, denominator);
            if (this.denominator < 0) {
                this.denominator *= -1;
                this.numerator *= -1;
            }
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.numerator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        return numerator+"/"+denominator;
    }

    public double toDouble() {
        numerator *= 1.0;
        return numerator/denominator;
    }

    public Fraction add(Fraction other) {
        int newnum = numerator * other.denominator + other.numerator * denominator;
        int newden = denominator * other.denominator;
        return new Fraction(newnum, newden);
    }

    public Fraction subtract(Fraction other) {
        int newnum = numerator * other.denominator - other.numerator * denominator;
        int newden = denominator * other.denominator;
        return new Fraction(newnum, newden);
    }

    public Fraction multiply(Fraction other) {
        int newnum = numerator * other.numerator;
        int newden = denominator * other.denominator;
        return new Fraction(newnum, newden);
    }

    public Fraction divide(Fraction other) {
        int newnum = numerator * other.denominator;
        int newden = other.numerator * denominator;
        return new Fraction(newnum, newden);
    }

    private static int euclideanAlgo(int n, int d) {
        int r;
        while(n != 0 && d != 0) {
            r = n%d;
            n = d;
            d = r;
        }
        return n;
    }

    public boolean equals(Fraction other) {
        return numerator == other.numerator && denominator == other.denominator;
    }

    private void check(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero!");
        }
    }

    public void toLowestTerm() {
        int lw = euclideanAlgo(this.numerator, this.denominator);
        this.numerator = this.numerator/lw;
        this.denominator = this.denominator/lw;
    }

    public static int gcd(int num, int den) {
        int gCd = euclideanAlgo(num, den);
        return gCd;
    }
}

