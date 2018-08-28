package com.hiuk.test.impl;

public class Main
{

    /*
    * Implementation > Bas class
    * It take a object which have implemented Exeable interface,
    * regardless of the base class, as long as it implement Exeable.
    * */
    private static void execute(Exeable ex){
        ex.execute();

    }

    public static void main(String[] args) {

        Exeable ex = new PowerFulExecutor();
        Exeable avgEx = new AverageExecutor();
        execute(ex);
        execute(avgEx);
    }
}
