package com.d9nich.exercise7;

public class NullDenominatorException extends  Exception{
    public NullDenominatorException() {
        super("the denominator of an object of class Fraction is 0.");
    }
}
