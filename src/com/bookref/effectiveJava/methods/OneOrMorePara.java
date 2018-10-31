package com.bookref.effectiveJava.methods;


/**
 * The thing here is if (int... arg), it will allow user to call with empty parameters,
 * which may not be desire by author.
 */
public class OneOrMorePara {
    
    /**
     * Better way, always make sure it have at least one para.
     * @param first
     * @param args
     * @return
     */
    public int min (int first, int ...args){

        int m = first;

        for (int i: args){
            if (i < m) {
                m = i;
            }
        }
        return m;
    }
}

