package com.hiuk.test.ab;


//It would have a name title filed to store its title and execute call sout a template string with title.
/*
* Abstract in other way would have much more detail about stuff like the actual implementation and var such and such...
*
* Also visibility can be set for method and member on abstract class.
* Ref: https://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface-and-abstract-class
* */
public abstract class Executor {

    String title;
    public void execute (){
        System.out.println(String.format("Hello %s", title));
    }

}
