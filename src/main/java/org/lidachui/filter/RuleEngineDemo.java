package org.lidachui.filter;

/**
 * RuleEngineDemo
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:48
 * @version: 1.0
 */
import java.math.BigDecimal;
import java.util.*;

public class RuleEngineDemo {

    public static void main(String[] args) {
        // 创建示例数据
        // 创建示例数据
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("A", "X", "P1", new BigDecimal("100")));
        dataList.add(new Data("B", "Y", "P2", new BigDecimal("200")));
        dataList.add(new Data("A", "Y", "P1", new BigDecimal("300")));
        dataList.add(new Data("B", "X", "P2", new BigDecimal("400")));
        dataList.add(new Data("B", null, "P2", new BigDecimal("400")));

        // 创建基本规则
        Rule<Data> marketCodeRule = new EqualsRule<>("marketCode", "A");
        Rule<Data> paymentCodeNotEqualsRule = new NotEqualsRule<>("paymentCode", "P1");
        Rule<Data> sourceCodeRule = new EqualsRule<>("sourceCode", "Y");


        // 创建组合规则 (marketCode == "A" AND paymentCode != "P1")
        CompositeRule<Data> andRule = new CompositeRule<>(null, new AndCombination());
        andRule.addRule(marketCodeRule);
        andRule.addRule(paymentCodeNotEqualsRule);

        // 创建最终规则 (marketCode == "A" AND paymentCode != "P1") OR sourceCode == "Y"
        CompositeRule<Data> orRule = new CompositeRule<>(null, new OrCombination());
        orRule.addRule(andRule);
        orRule.addRule(sourceCodeRule);
        Rule<Data> isNullCodeRule = new IsNullRule<>("sourceCode");
        orRule.addRule(isNullCodeRule);

        List<Data> filter = new RuleEngine<>(orRule).filter(dataList);
        for (Data data : filter) {
      System.out.println(data);
        }
    }

}
