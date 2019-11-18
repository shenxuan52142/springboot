package com.shenxuan.springboot.Enum;

public enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id=name();
        String lower = id.substring(0).toLowerCase();
        return id.charAt(1) + lower;
    }

//    public static void main(String[] args) {
//        for (SpaceShip s:values()){
//            System.out.println(s);
//        }
//    }
}
