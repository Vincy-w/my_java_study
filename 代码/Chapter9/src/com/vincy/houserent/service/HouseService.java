package com.vincy.houserent.service;

import com.vincy.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;//house number
    private int idCounter = 1;//记录当前id的值

    public HouseService(int size) {
        houses = new House[size];//当创建HouseService对象时，指定数组大小
        houses[0] = new House(1, "jink", "112", "wutopin", 2000, "未出租");
    }

    public House findById(int findId){
        for (int i = 0; i < houseNums; i++) {
            if(findId==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }

    public boolean add(House newHouse) {
        if (houseNums == houses.length) {
            System.out.println("数组已满，不能再添加");
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public House[] list() {
        return houses;
    }
}
