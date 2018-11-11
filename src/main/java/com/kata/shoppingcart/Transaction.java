package com.kata.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author vamshikirangullapelly
 */
public class Transaction {

    private final Set<PricingRule> pricingRules;
    private final Map<Item, Long> shoppingBasket = new HashMap<Item, Long>();

    Transaction(Set<PricingRule> pricingRules) {
        super();
        this.pricingRules = pricingRules;
    }

    public Transaction scan(Item item) {
        Long amount = shoppingBasket.get(item);

        if(amount != null) {
            amount++;
        } else {
            amount = 1L;
        }

        shoppingBasket.put(item, amount);
        return this;
    }

    public Set<PricingRule> getPricingRules() {
        return pricingRules;
    }

    public Map<Item, Long> getShoppingBasket() {
        return shoppingBasket;
    }
}