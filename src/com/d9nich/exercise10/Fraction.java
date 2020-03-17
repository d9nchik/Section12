package com.d9nich.exercise10;

import com.d9nich.exercise7.NullDenominatorException;

public class Fraction {
    private int nominator, denominator;

    public Fraction(int nominator, int denominator) throws NullDenominatorException {
        if (denominator==0)
            throw new NullDenominatorException();
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }
}
