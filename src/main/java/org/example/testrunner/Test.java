package org.example.testrunner;

public class Test {
    Object input;
    Object target;
    Object output;

    public <T, U> Test(Object input, Object output) {
        this.input =  input;
        this.output = output;
    }

    public <T, U> Test(Object input, Object target, Object output) {
        this.input =  input;
        this.target = target;
        this.output = output;
    }
}
