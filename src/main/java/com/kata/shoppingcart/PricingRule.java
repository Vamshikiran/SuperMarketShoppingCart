package com.kata.shoppingcart;

/**
 * @author vamshikirangullapelly
 */

public interface PricingRule {
    Item getItem();
    Unit apply(long amount);
}