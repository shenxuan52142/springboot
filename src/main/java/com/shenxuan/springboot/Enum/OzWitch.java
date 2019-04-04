package com.shenxuan.springboot.Enum;

public enum  OzWitch {
    WEST("Miss Gulch,aka the"),
    NORTH("i am NORTH"),
    EAST("i am EAST "),
    SOUTH("i am SOUTH");
    private String descriptio;
    private OzWitch(String descriptio){
        this.descriptio = descriptio;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public static void main(String[] args) {
        for (OzWitch witch:OzWitch.values()){
            System.out.println(witch+": "+witch.getDescriptio());
        }
    }
}
