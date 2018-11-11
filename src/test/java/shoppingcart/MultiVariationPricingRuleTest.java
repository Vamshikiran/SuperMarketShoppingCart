package shoppingcart;

import com.kata.shoppingcart.MultiVariationPricingRule;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class MultiVariationPricingRuleTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(MultiVariationPricingRule.class).verify();
    }

}
