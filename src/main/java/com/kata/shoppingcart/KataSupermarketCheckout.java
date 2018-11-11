package com.kata.shoppingcart;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;

/**
 * @author vamshikirangullapelly
 * This class is used to scan the item apply the pricing rules and calculate the total price .
 */

public class KataSupermarketCheckout {



    public Transaction startTransaction(final Set<PricingRule> pricingRules) {
        return new Transaction(pricingRules);
    }

    public long calculateTotalPrice(final Transaction transaction) {
        final List<PricingRule> orderedPricingRules = orderPricingRules(transaction.getPricingRules());
        final Map<Item, Long> shoppingBasket = newHashMap(transaction.getShoppingBasket());
        int totalPrice = 0;

        for(PricingRule rule : orderedPricingRules) {
            if(shoppingBasket.containsKey(rule.getItem())) {
                long amount = shoppingBasket.get(rule.getItem());
                Unit unit = rule.apply(amount);
                totalPrice += unit.getPrice();
                shoppingBasket.put(rule.getItem(), amount - unit.getRemainder());
            }
        }

        return totalPrice;
    }

    private List<PricingRule> orderPricingRules(Set<PricingRule> pricingRules) {
        return Ordering.natural().reverse().onResultOf(new Function<PricingRule, Integer>() {
            public Integer apply(PricingRule rule) {
                if(!rule.getClass().isAnnotationPresent(Order.class)) {
                    return 0;
                } else {
                    Order order = rule.getClass().getAnnotation(Order.class);
                    return order.value();
                }
            }
        }).sortedCopy(pricingRules);
    }

}
