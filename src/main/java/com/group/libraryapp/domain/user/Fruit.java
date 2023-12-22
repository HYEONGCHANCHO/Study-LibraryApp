package com.group.libraryapp.domain.user;

public class Fruit {
    private String name;
    private int price;

    public String getName() {   //getter 가 있을 때 json 형태로 반환해준다.
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Fruit(String name, int price) {

        this.name = name;
        this.price = price;
    }
}
