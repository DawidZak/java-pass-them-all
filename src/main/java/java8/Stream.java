package java8;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void stream_7(){
        //what is diffrence?
        //forEach is not deterministic
        //forEachOrdered is (try with parallel)
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        integerList.stream().forEachOrdered(System.out::println);
        integerList.stream().forEach(System.out::println);

    }
    //findFirst returns Optional
    public void stream_8(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 1);
        Optional<Integer> optional = integerList.stream().findFirst();
        int a = integerList.stream().findFirst().orElse(1);
    }
    //distinct
    public void stream_9(){
        List<Integer> integerList = Arrays.asList(8, 98, 312, 8);
        int a = (int) integerList.stream().distinct().count();
    }
    //#filter #map #sorted #findFirst
    public void stream_10(){
        //For strings starts with "c" convert to UpperCase then sort and find first
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        String string = myList.stream()
                .filter(x -> x.startsWith("c"))
                .map(String::toUpperCase)
                .sorted().findFirst()
                .orElse("none");
    }
    //#IntStream
    public void stream_11(){
        IntStream.range(1,11).forEach(System.out::println);

    }

    public void  stream_12(){
        //Add 11 Model object to modelList with uniqe String
        List<Model> modelList = new ArrayList<>();
        IntStream.range(1,12).forEach(x-> modelList.add(new Model("a"+x)));
        modelList.forEach(System.out::println);
    }

    public void stream_13(){
        //Get thread-pool uses to Parallel streams default 3
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }

    public void stream_14(){
        //As JVM arguments use -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }

     //#sorted+comparator+asc+firstElemenet
    public void stream_15(){
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        Comparator<Model> modelComparator = Comparator.comparingInt(Model::getId);
        myList.stream().sorted(modelComparator).forEach(System.out::println);

    }

    //#sorted+reversed+firstElement+desc+comparator
    public void stream_16(){
        //Find the highest value
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        myList.stream().sorted(Comparator.comparing(Model::getId).reversed()).forEach(System.out::println);
        myList.stream().sorted(Comparator.comparing(Model::getId).reversed()).findFirst().get().getId();
    }

     //#concat+java.util.stream.Stream
    public void stream_17(){
        List<String> stringList1 = Arrays.asList("aa","bb");
        List<String> stringList2 = Arrays.asList("cc","dd");
        List<String> stringList3 = new ArrayList<>(); // aa cc bb dd
        java.util.stream.Stream stream = java.util.stream.Stream.concat(stringList1.stream(),stringList2.stream());
        stream.forEach(x-> stringList3.add(x.toString()));
        stringList3.forEach(System.out::println);

    }

     //check stream parallerlism
    public void stream_18(){
        List<String> stringList1 = Arrays.asList("aa","bb");
        stringList1.stream().isParallel();
    }

    public void stream_19(){
        List<Model> myList = Arrays.asList(new Model(23),new Model(11), new Model(12312),new Model(99));
        int sum =  myList.stream().mapToInt(Model::getId).sum();

    }
}
