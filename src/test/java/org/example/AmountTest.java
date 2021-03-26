package org.example;

import org.example.model.Amount;
import org.example.model.Error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AmountTest {

    @Test
    @DisplayName("It shouldn't accept negative value for Amount instance in substract method argument")
    void it_shouldnt_accept_negative_value_for_Amount_instance_in_substract_method_argument(){

        BigDecimal amountValue = BigDecimal.valueOf(-50);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(amountValue));

        String expectedMessage = Error.NEGATIVE_FORBIDDEN.toString();
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    @DisplayName("It should return 50 when Amount is 50")
    void it_should_return_50_when_Amount_is_50(){

        Amount amount = new Amount(BigDecimal.valueOf(50));

        Assertions.assertEquals(BigDecimal.valueOf(50), amount.getValue());

    }
}
