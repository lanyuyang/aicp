package com.iflytek.tr.nlp.learn.Lambda.list;

import com.alibaba.fastjson.JSON;
import com.iflytek.tr.nlp.learn.Lambda.list.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(10,"xiaohua"));
        students.add(new Student(11, "ming"));

        System.out.println(JSON.toJSON(students));

        // 1、提取Student中age成独立的List<Integer>
        List<Integer> ageList = students.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println(JSON.toJSON(ageList));
        // 2、提取Student中id成map
        Map<Integer, Student> studentMap = students.stream().collect(Collectors.toMap(Student::getAge,o -> o));
        System.out.println(JSON.toJSON(studentMap));
        // 3、从students中找到age = 10的Student实例
        students =  students.stream().filter(student -> student.getAge() == 10).collect(Collectors.toList());
        System.out.println(JSON.toJSON(students));
        // 3、从students中找到age = 10的Student实例
        Student studentTemp=  students.stream().filter(student -> student.getAge() == 10).findFirst().orElse(null);
        System.out.println(JSON.toJSON(studentTemp));
        // 4、students中是否存在age = 10的Student实例   anyMatch 写法
        boolean isHave = students.stream().anyMatch(student -> student.getAge() == 10);
        if (isHave){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }
        // 4、students中是否存在age = 10的Student实例   filter写法
        boolean isHave1 = students.stream().filter(student -> student.getAge() == 10).findAny().isPresent();
        if (isHave1){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }
        // 5、除去student 重复实例 distinct()
        students.add(new Student(10,"xiaohua"));
        System.out.println(JSON.toJSON(students));
        students = students.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSON(students));

    }

    public static void covert(){
        int[] array = {1, 2, 5, 5, 5, 5, 6, 6, 7, 2, 9, 2};

        /*int[]转list*/
        //方法一：需要导入apache commons-lang3  jar
//        List<Integer> list = Arrays.asList(ArrayUtils.toObject(array));
        //方法二：java8及以上版本
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        /*list转int[]*/
        //方法一：
        Integer[] intArr =  list.toArray(new Integer[list.size()]);
        //方法二：java8及以上版本
        int[] intArr1 =  list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
