package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Dawid on 10.07.2017.
 */
public class Stream {


    public boolean stream_1() {
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        //https://stackoverflow.com/questions/22561614/java-8-streams-min-and-max-why-does-this-compile
        return 312 == integerList.stream().max(Integer::compare).orElse(1);
    }


    public boolean stream_2(){
        List<String> strings = Arrays.asList("abc");
        return "ABC".equals(strings.stream().map(String::toUpperCase).findAny().orElse("a"));
    }

    //skip one element

    public boolean stream_3(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        List<Integer> integerListSkip;
        integerListSkip = integerList.stream().skip(1).collect(Collectors.toList());
        return integerList.size()-1 == integerListSkip.size();

    }


    public boolean stream_4(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        return true == integerList.stream().allMatch( x-> x >= 1);

    }


    public boolean stream_5(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        Predicate<Integer> p1 = x-> x>=1;
        return true == integerList.stream().allMatch(p1);

    }

    public boolean stream_6(){
        List<Model> modelList = Arrays.asList(new Model(32),new Model(11),new Model(111));
        int count = (int) modelList.stream().filter(x -> x.getId() > 35).count();
        return count == 1;
    }

}
