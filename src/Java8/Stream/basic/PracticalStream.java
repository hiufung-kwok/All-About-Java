package Java8.Stream.basic;

import java.util.stream.IntStream;
/*
* Ref: http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/
*
* Following demo the use of Int Stream, it would be practical especially during the Dev stage.
* */
public class PracticalStream {

    public static void main(String[] args) {

//        Range stream [1...1000]
        IntStream.rangeClosed(1,1000);
//        Close range, exclude the last one (1, 1000)
        IntStream.range(1, 1000);

//        Keep produce number from arg0 and transform by arg1 (Infinite stream)
        IntStream.iterate(0, i -> i+2);
//        More practical use would be call with .limit( )
//        First 100 candidates
        IntStream.iterate(1, i -> i*2).limit(100);




    }
}
