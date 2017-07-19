package java8;

import com.sun.media.sound.ModelStandardDirector;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dawid on 08.07.2017.
 */
public class Stream {

    @Test
    public void stream_1() {
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        //https://stackoverflow.com/questions/22561614/java-8-streams-min-and-max-why-does-this-compile

        assertEquals(312,2); // replace 2 with expression


    }

    @Test
    public void stream_2(){
        List<String> strings = Arrays.asList("abc");
        assertEquals("ABC","d"); //replace d with expression
    }

    //skip one element
    @Test //#skip
    public void stream_3(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        List<Integer> integerListSkip;////here use skip and pass variable to assert
        assertEquals(integerList.size()-1,2);

    }

    @Test //#allMatch
    public void stream_4(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        assertEquals(true,false); //here use allMatch;

    }


    @Test //#Predicate<Integer>
    public void stream_5(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        assertEquals(true,false); //use Predicate<Integer> to pass this test with allMatch

    }

    @Test //#count
    public void stream_6(){
        //count elements which has value > 35
        int count = 0;

        assertEquals(1,count);
    }

    @Test //#forEachOrdered
    public void stream_7(){
        //what is diffrence? if you know change assertEquals
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        integerList.stream().forEachOrdered(System.out::println);
        integerList.stream().forEach(System.out::println);
        assertEquals(true,false);
    }

    @Test //#findFirst+Optional
    public void stream_8(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        assertEquals(8,1);
    }

    @Test //#distinct
    public void stream_9(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 8);
        int a = 0;
        assertEquals(3,a);
    }
    @Test //#filter #map #sorted #findFirst
    public void stream_10() {
        //For strings starts with "c" convert to UpperCase then sort and find first
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        String string = "dd";

        assertEquals("C1",string);
    }

    @Test //#IntStream
    public void stream_11(){
        //Replace wtih java 8 using IntStream
        for(int x = 1;x < 11;x++){
            System.out.println(x);
        }

        assertEquals(true,false);
    }
    @Test //#IntStream forEach
    public void  stream_12(){
        //Add 11 Model object to modelList with uniqe String
        List<Model> modelList = new ArrayList<>();
        assertEquals(true,false);
    }
    @Test //#ForkJoinPool
    public void stream_13(){
        //Get thread-pool uses to Parallel streams default 3
        ForkJoinPool commonPool;
        assertEquals(0,1); //here expresion
    }

    @Test //#ForkJoinPool
    public void stream_14(){
        //Change thread-pool amount used to Parallel stream with JVM arguments to 5
        ForkJoinPool commonPool;
        assertEquals(5,3);

    }
    @Test //#sorted+comparator+asc+firstElemenet+asc
    public void stream_15(){
        //Find the lowest value
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        Comparator<Model> modelComparator;
        assertEquals(11,0);// model id
    }

    @Test //#sorted+reversed+firstElement+desc+comparator
    public void stream_16(){
        //Find the highest value
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        assertEquals(12312,1);


    }

    @Test //#concat+java.util.stream.Stream
    public void stream_17(){
        List<String> stringList1 = Arrays.asList("aa","bb");
        List<String> stringList2 = Arrays.asList("cc","dd");
        List<String> stringList3 = new ArrayList<>(); // aa cc bb dd


        assertEquals(stringList3.size(),4);

    }

    @Test //check stream parallerlism
    public void stream_18() {
        List<String> stringList1 = Arrays.asList("aa", "bb");

        assertEquals(false, true);// replace true with expression

    }

    @Test //mapToInt+sum+method reference
    public void stream_19(){
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        int sum =  1; //change it
        assertEquals(12445,sum);
    }

    @Test //mapToInt+average
    public void stream_20(){
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        Double result = 2d;
        assertEquals(Double.valueOf(3111.25),result);
    }
}
