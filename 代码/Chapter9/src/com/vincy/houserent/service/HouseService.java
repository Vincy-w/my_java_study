package com.vincy.houserent.service;

import com.vincy.houserent.domain.House;

public class HouseService {
    private House[] houses;

    public HouseService(int size){
        houses =new House[size];//当创建HouseService对象时，指定数组大小
        houses[0]=new House(1,"jink","112","wutopin",2000,"未出租");
    }

    public House[] list(){
        return houses;
    }
}
