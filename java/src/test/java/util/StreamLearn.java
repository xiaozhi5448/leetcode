package util;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class StreamLearn {

    static List<String> words = new LinkedList<>();

    @BeforeClass
    public static void init(){
        words.add("w1");
        words.add("");
        words.add("ddd2");
        words.add("aaa2");
        words.add("bbb1");
        words.add("aaa1");
        words.add("bbb3");
        words.add("ccc");
        words.add("bbb2");
        words.add("ddd1");
    }

    @Test
    public void testFilter(){
        words.stream().filter((s)-> s.startsWith("a")).forEach(System.out::println);
    }

    @Test
    public void testSorted(){
        words.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void testMap(){
        words.stream().map((s)->(s.toUpperCase())).sorted((a,b)->(b.compareTo(a))).forEach(System.out::println);
    }

    @Test
    public void testMatch(){
        boolean anyStartsA = words.stream().anyMatch((s)->(s.startsWith("a")));
        System.out.println(anyStartsA);
        boolean allStartsA = words.stream().allMatch((s)->(s.startsWith("a")));
        System.out.println(allStartsA);
        boolean noneStartsA = words.stream().noneMatch((s)->(s.startsWith("a")));
        System.out.println(noneStartsA);
    }

    @Test
    public void count(){
        long count = words.stream().filter((s)->(s.startsWith("b"))).count();
        System.out.println(count);
    }

    @Test
    public void reduce(){
        System.out.println(words.stream().reduce((s1,s2)->(s1 + "#" + s2)));
    }
}
