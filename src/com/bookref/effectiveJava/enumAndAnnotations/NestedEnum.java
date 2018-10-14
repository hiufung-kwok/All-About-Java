package com.bookref.effectiveJava.enumAndAnnotations;

import java.util.*;

/**
 * Ref: Effective Java Item: 38
 */
public class NestedEnum {

    enum Ins { GUITAR, BASS, DRUM }


    final String name;

    final Ins ins;



    NestedEnum(String name, Ins Ins) {

        this.name = name;
        this.ins = Ins;

    }

    @Override public String toString() {

        return name;

    }


    public static void main(String[] args) {


//        Data set
        ArrayList<NestedEnum> items = new ArrayList<NestedEnum>();
        items.add(new NestedEnum("Hiu", Ins.BASS));
        items.add(new NestedEnum("Tat", Ins.GUITAR));
        items.add(new NestedEnum("Chung", Ins.GUITAR));


//        Proper way to construct a map to host element categorized by ins
        EnumMap<Ins, Set<NestedEnum>> NestedEnumsByIns =  new EnumMap<>(NestedEnum.Ins.class);

//        Init collection
        for (NestedEnum.Ins ins : NestedEnum.Ins.values()){
            NestedEnumsByIns.put(ins, new HashSet<>());
        }

//        Insert item
        items.forEach( p -> NestedEnumsByIns.get(p.ins).add(p));

        System.out.println(NestedEnumsByIns);
    }
}
