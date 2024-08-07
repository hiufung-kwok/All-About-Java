package com.hiuk.test.mutliThreadCache;

import java.util.HashMap;

public class SingleCache {

    HashMap<Integer, Book> c;

    public SingleCache() {
        this.c = new HashMap<Integer, Book> ();
    }


    public boolean exist(int id) {
        return c.containsKey(id);
    }

    public Book get (int id){
        return c.get(id);
    }


    public void put (Book book){
        c.put(book.getId(), book);
    }
}
