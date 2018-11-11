package shoppingcart;

import com.kata.shoppingcart.IndividualItemPricingRule;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IndividualItemPricingRuleTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IndividualItemPricingRule.class).verify();
    }

}
