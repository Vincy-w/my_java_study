package com.vincy.houserent.view;

import com.vincy.houserent.domain.House;
import com.vincy.houserent.service.HouseService;
import com.vincy.houserent.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';//接收用户选择
    private HouseService houseService = new HouseService(10);

    public void updateHouse() {
        System.out.println("=============修改房屋信息=============");
        System.out.println("请选择待修改房屋编号(-1退出):");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("==============已放弃修改房屋信息==============");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("==============修改房屋编号不存在==============");
            return;
        }
        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");//若用户直接回车不修改，默认""
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.println("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=============修改房屋信息成功=============");
    }

    public void findHouse() {
        System.out.println("=============查找房屋信息=============");
        System.out.println("请输入要查找的id:");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("=============查找房屋信息不存在=============");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void delHouse() {
        System.out.println("=============删除房屋=============");
        System.out.println("请输入待删除房屋编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("============放弃删除房屋============");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("============删除房屋信息成功============");
            } else {
                System.out.println("============房屋编号不存在，删除失败============");
            }
        } else {
            System.out.println("============放弃删除房屋============");
        }
    }

    public void addHouse() {
        System.out.println("=============添加房屋=============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("==============添加房屋成功==============");
        } else {
            System.out.println("==============添加房屋失败==============");
        }
    }

    public void listHouses() {
        System.out.println("============房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {//房屋数量不等于数组长度！
            if (houses[i] == null) break;
            System.out.println(houses[i]);
        }
        System.out.println("============房屋列表显示完毕============");
    }

    public void mainMenu() {
        do {
            System.out.println("============房屋出租系统============");
            System.out.println("\t\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退      出");
            System.out.println("请输入你的选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }

}
