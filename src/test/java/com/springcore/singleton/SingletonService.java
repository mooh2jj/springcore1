package com.springcore.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // private제어자로 생성자 이러면 new 연산자로 접근 못해!
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");

    }
}
