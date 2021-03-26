package org.example.model;

import java.math.BigDecimal;

public class Amount {
    private BigDecimal value;

    public Amount(BigDecimal value){
        if(value.compareTo(BigDecimal.ZERO) >= 0){
            this.value = value;
        }else{
            throw new IllegalArgumentException(Error.NEGATIVE_FORBIDDEN.toString());
        }
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal amount) {
        this.value = amount;
    }
}
