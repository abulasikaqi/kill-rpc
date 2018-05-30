package com.imya.prepare.reflect;

import java.lang.reflect.Method;

/**
 * Created by LL on 2018/5/30 0030.
 */
public class Person {
    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.imya.prepare.reflect.Person");
        Person person = (Person) clazz.newInstance();
        System.out.println(person);

        System.out.println("----------------------------------------");

        for (Method method : clazz.getMethods()) {
            System.out.println(method);
        }
    }
}
