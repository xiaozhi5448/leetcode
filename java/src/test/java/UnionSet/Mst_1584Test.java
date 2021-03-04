package UnionSet;

import junit.framework.TestCase;

import java.util.Arrays;

class Person{
    int age;
    String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        Person p2 = (Person)obj;
        return age == p2.age && name.equals(p2.name);
    }
}

public class Mst_1584Test extends TestCase {

    public void testMinCostConnectPoints() {
        Mst_1584 util = new Mst_1584();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int cost = util.minCostConnectPoints(points);
        System.out.println(String.format("%s: %d", Arrays.toString(points), cost));
        Object o = new Object();

        Person p1 = new Person(13, "abcdefg");
        Person p2 = new Person(13, "abcdefg");
        System.out.println(p1 == p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }
}