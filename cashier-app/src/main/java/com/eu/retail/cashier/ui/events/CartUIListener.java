package com.eu.retail.cashier.ui.events;

import com.eu.retail.core.model.Product;

import java.math.BigDecimal;

public interface CartUIListener {
        void requestWeightInput(Product product);
        void uiRequestUpdateCartTotal(BigDecimal sum);
    }

