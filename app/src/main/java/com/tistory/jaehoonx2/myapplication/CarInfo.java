package com.tistory.jaehoonx2.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarInfo {
    String carName;
    String carNo;
    long inTime;
    String inTimeTxt;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

    public void setIn(String carName, String carNo){
        this.carName = carName;
        this.carNo = carNo;
        Date in = new Date();
        this.inTime = in.getTime();
        String inT = simpleDateFormat.format(in);
        this.inTimeTxt = inT;
    }

    public String setOut(){
        Date out = new Date();
        long outTime = out.getTime();
        long during = outTime - inTime;
        int price;
        during = during/10000;
        if ((int)during/30 < 1)
            price = 1000;
        else price = ((int)during/30) * 1000;

        init();

        return "주차시간 " + (int)during + "분의 주차요금은 " + price + "원입니다.";
    }

    private void init(){
        this.carName = "";
        this.carNo = "";
        this.inTime = 0;
        this.inTimeTxt = "";
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public long getInTime() {
        return inTime;
    }

    public String getInTimeTxt(){
        return inTimeTxt;
    }

    public void setInTime(long inTime) {
        this.inTime = inTime;
    }
}
