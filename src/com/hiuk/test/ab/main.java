package com.hiuk.test.ab;


/*
* Kind of similar to interface but this time they would be able to treat as the same object.
* */
public class main {

    private static void exe (Executor ex) {
        ex.execute();
    }


    public static void main(String[] args) {
        Executor para = new ParallelExecutor();
        Executor ul  = new UltimateExecutor();
        exe(para);
        exe(ul);
    }
}
