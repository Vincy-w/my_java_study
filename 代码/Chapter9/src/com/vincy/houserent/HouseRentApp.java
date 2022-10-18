package com.vincy.houserent;

import com.vincy.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，显示主菜单，是整个程序入口
        new HouseView().mainMenu();
        System.out.println("========已退出房屋租赁系统========");
    }
}
