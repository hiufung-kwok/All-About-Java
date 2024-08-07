package com.hiuk.test.mutliThreadCache;

import java.util.Random;

public class Client {



    private static void print (Book b, long time) {
        System.out.println(b.toString() + " [" + time + "ms]");
    }


    public static void  navie() throws InterruptedException {
        Random r = new Random();

        for (int i=0 ; i<100 ; i++){
            long start  = System.currentTimeMillis();
            Book b = DB.getBook(r.nextInt((100)) );
            long timeTaken = System.currentTimeMillis() - start;
            print(b, timeTaken);
        }
    }

    public static void  withCache() throws InterruptedException {
        Random r = new Random();
        SingleCache c = new SingleCache();
        int totalOps = 100000;


        for (int i=0 ; i<totalOps ; i++){
            long start  = System.currentTimeMillis();

            int id = r.nextInt(100);

            Book b;
            if (c.exist(id)) {
                b = c.get(id);
            }else {
                b = DB.getBook(id);
                c.put(b);
            }

            long timeTaken = System.currentTimeMillis() - start;
            print(b, timeTaken);
        }


    }

//    TBC
    public static void multiCache () {

    }






    public static void main(String[] args) throws InterruptedException {

//        navie();
        withCache();

    }
}
