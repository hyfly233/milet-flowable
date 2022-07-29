package com.hyfly.milet.rewrite.enums;

public enum DeleteFlag {
    NORMAL(0, "正常"), DELETED(1, "已删除");
    private int code;
    private String name;

    private DeleteFlag(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}