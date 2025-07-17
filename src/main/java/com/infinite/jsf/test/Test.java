package com.infinite.jsf.test;

class Parent {
    void show() { System.out.print("Parent "); }
}
class Child extends Parent {
    void show() { System.out.print("Child "); }
}
public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        ((Parent)p).show();
    }
}