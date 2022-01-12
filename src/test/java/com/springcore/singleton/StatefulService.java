package com.springcore.singleton;

public class StatefulService {

//    private int price;

    //    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
//    }
    // 지역변수화로 변환!
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
