package shoppingcart;

import com.kata.shoppingcart.Item;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class ItemTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Item.class).verify();
    }

}
