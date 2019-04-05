package com.shenxuan.springboot.Enum;

import java.util.EnumMap;

import static com.shenxuan.springboot.Enum.Input.*;

public enum  Category {
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SOAP, SODA),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... types){
        values = types;
    }

    private static EnumMap<Input, Category> categories =
            new EnumMap<Input, Category>(Input.class);
    static {
//        for (Category c:)
    }
}
