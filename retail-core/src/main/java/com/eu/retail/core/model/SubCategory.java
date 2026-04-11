package com.eu.retail.core.model;

import lombok.Getter;

@Getter
public class SubCategory {
    private final int id;
    private final String name;
    private final int parentCategoryId;

    public SubCategory(int id, String name, int parentCategoryId) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }
}
