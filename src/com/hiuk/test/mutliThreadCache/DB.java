package com.hiuk.test.mutliThreadCache;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Mock up for actual DB  access which always have a 50ms delay
 */
public class DB {

    public static Book getBook (int id) throws InterruptedException {

        Thread.sleep(50);
        return new Book(id, RandomStringUtils.random(10));
    }
}
