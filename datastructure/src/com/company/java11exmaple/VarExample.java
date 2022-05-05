package com.company.java11exmaple;

public class VarExample {
    public static void main(String[] args) {
        //below example works fine with Java 8 and higher versions.
        Cal cal = (a, b) -> a + b;
        int result = cal.sum(10, 20);
        System.out.println(result);
        //also another example works fine with Java 8 and higher versions.
        cal = (int a, int b) -> a + b;
        result = cal.sum(10, 20);
        System.out.println(result);
        //java 11 example with var keyword in lampda which were not possible in java8
        cal = (var x, var y) -> x + y;
        result = cal.sum(10, 20);
        System.out.println(result);

//        While using var with lambda expression make sure you keep in mind the following scenario and rules.
//        (var s1, s2) -> s1 + s2 //no skipping allowed
//                (var s1, String y) -> s1 + y //no mixing allowed

//        var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
    }
}
