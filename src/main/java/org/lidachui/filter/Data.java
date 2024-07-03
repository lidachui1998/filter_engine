package org.lidachui.filter;

/**
 * Data
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:48
 * @version: 1.0
 */
import java.math.BigDecimal;

public class Data {
    private String marketCode;
    private String sourceCode;
    private String paymentCode;
    private BigDecimal amount;

    public Data(String marketCode, String sourceCode, String paymentCode, BigDecimal amount) {
        this.marketCode = marketCode;
        this.sourceCode = sourceCode;
        this.paymentCode = paymentCode;
        this.amount = amount;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Data{" +
                "marketCode='" + marketCode + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}
