package com.kata.shoppingcart;

/**
 * @author vamshikirangullapelly
 *         
 */

public final class IndividualItemPricingRule implements PricingRule {

    private final Item item;
    private final long price;

    private IndividualItemPricingRule(final Item item, final long price) {
        super();
        this.item = item;
        this.price = price;
    }

    public static PricingRuleBuilder pricingRuleFor(Item item) {
        return new PricingRuleBuilder(item);
    }

    public Item getItem() {
        return item;
    }

    public Unit apply(final long amount) {
        return new Unit(amount * price, 0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + (int) (price ^ (price >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IndividualItemPricingRule other = (IndividualItemPricingRule) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "item " + item + " at " + price + "p each";
    }

    public static class PricingRuleBuilder {

        private final Item item;

        public PricingRuleBuilder(final Item item) {
            super();
            this.item = item;
        }

        public IndividualItemPricingRule atPrice(long price) {
            return new IndividualItemPricingRule(item, price);
        }
    }

}
