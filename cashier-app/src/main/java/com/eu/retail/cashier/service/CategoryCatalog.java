package com.eu.retail.cashier.service;

import com.eu.retail.core.model.ParentCategory;
import com.eu.retail.core.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryCatalog {

    public List<ParentCategory> getAllParentCategories() {
        List<ParentCategory> parentCategories = new ArrayList<>();

        String sql = """
            SELECT id, name
            FROM parent_categories
            ORDER BY name
            """;

        return  parentCategories;
    }

    public List<SubCategory> getSubCategories() {
        List<SubCategory> subCategories = new ArrayList<>();

        String sql = """
            SELECT id, name, parent_category_id
            FROM sub_categories
            WHERE parent_category_id = ?
            ORDER BY name
            """;

        return  subCategories;
    }
}
