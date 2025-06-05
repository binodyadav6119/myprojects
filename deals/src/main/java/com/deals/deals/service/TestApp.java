package com.deals.deals.service;

class check
{
    int a;
    int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

public class TestApp {
    public static void main(String[] args) {
        check check = new check();
        check.setA(10);
        check.setB(20);

        check check1=check;
        check1.setA(11);
        System.out.println(check1.getA());


        String a="binod";
        String b=a;
        a="binod1";
        b="yadav";
        System.out.println(b);
        System.out.println(a);

        System.out.println("sdfghjk");
    }
}
