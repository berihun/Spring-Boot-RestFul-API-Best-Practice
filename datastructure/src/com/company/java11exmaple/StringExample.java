package com.company.java11exmaple;

import java.util.stream.Stream;

public class StringExample {
    //local variable var eaxmeple

    public static void main(String[] args) {
        String str = "Studytonight";
        boolean r = str.isBlank();
        System.out.println(r);
        str = "";
        r = str.isBlank();
        System.out.println(r);
        //lines example
        str = "StudyTonight \n is a \r technical \n portal";
        Stream<String> lines = str.lines();
        lines.forEach(System.out::println);

        //avoid leading and trailing space example string
        str = "      Studytonight portal ";
        System.out.println(str);
        String str2 = str.strip();
        System.out.println(str2);
        //another example for strip
        str = "      Studytonight portal";
        System.out.println(str);
        str2 = str.stripLeading();
        System.out.println(str2);

        //another example for strip
        str = "    Studytonight portal   ";
        System.out.println(str);
        System.out.println(str.length());
        str2 = str.stripTrailing();
        System.out.println(str2);
        System.out.println(str2.length());

        //string repeat example
        str = "@";
        System.out.println(str);
        str2 = str.repeat(3);
        System.out.println(str2);
        str = "mac";
        System.out.println(str);
        str2 = str.repeat(5);
        System.out.println(str2);
    }
}
