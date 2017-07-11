package java8;

import com.sun.media.sound.ModelStandardDirector;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    @Test
    public void stream_3(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        List<Integer> integerListSkip;////here use skip and pass variable to assert
        assertEquals(integerList.size()-1,2);

    }

    @Test
    public void stream_4(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        assertEquals(true,false); //here use allMatch;

    }


    @Test
    public void stream_5(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        assertEquals(true,false); //use Predicate<Integer> to pass this test with allMatch

    }

    @Test
    public void stream_6(){
        //count elements which has value > 35
        int count = 0;

        assertEquals(1,count);
    }
}
