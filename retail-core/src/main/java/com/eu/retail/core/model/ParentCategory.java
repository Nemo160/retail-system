package com.eu.retail.core.model;

import lombok.Getter;

@Getter
public class ParentCategory {
    private final int id;
    private final String name;

    public ParentCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
