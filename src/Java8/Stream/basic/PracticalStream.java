package Java8.Stream.basic;

import java.util.stream.IntStream;


/*
* Ref: http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/
* 
* This segment of code used to demonstrate how to stream of data in just one line manner. Which would be 
* useful especailly for testing purpose, also random stream can be used for testing-purpose (Fuzzing). 
* 
* 
* This the most common one would be ```IntStream.rangeClose()``` and ```IntStream.range``` which both of 
* the call take two arg, seed and the threadhold to stop. Let say 1, 1000 passed in. The method would 
* return [1,1000] -> 1...1000 || [1, 1000) 1...999 depends of the call type. [Url to Example]
* 
* It come into handy when a sequence of number is needed for test-case but just too troublesome to 
* tpye int arr = new int[](1,2,3.....); 999% time saver.
* 
* Above method call only work for sequentially int. What happen you want some thing in pattern? Stuff
* like every even number from 0 to 500;
* 
* In this sense the ```ObjStream.iterate()``` and ```Stream.limit()``` would come into help. By combine 
* both call, it's capable to produce stream of number that fullfill your pattern. Example can be
* seen on [URL]. Just noted that ```iterate( )``` by itself is a finite Stream, just beware of it. 
* And personally personing I wouldn't prefer to use it on production. A finite stream would make 
* all downStream processing method keep working forever and you program basically screwed. 
* 
* 
* 
* */
public class PracticalStream {

    public static void main(String[] args) {

//        Range stream [1...1000]
        IntStream.rangeClosed(1,1000);
//        Close range, exclude the last one (1, 1000)
        IntStream.range(1, 1000);
//        As arr
        int[] arr = IntStream.range(0, 500).toArray();

//        Keep produce number from arg0 and transform by arg1 (Infinite stream)
        IntStream.iterate(0, i -> i+2);
//        More practical use would be call with .limit( )
//        First 100 candidates
        IntStream.iterate(1, i -> i*2).limit(100);
    }
}
