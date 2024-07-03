package org.lidachui.filter;

import java.util.*;
import java.util.function.Predicate;

/**
 * RuleParser
 *
 * @author: lihuijie
 * @date: 2024/7/3 23:53
 * @version: 1.0
 */
public class RuleParser {

    public <T> Rule<T> parseRule(Map<String, Object> ruleData) {
        String type = (String) ruleData.get("type");
        String attributeName = (String) ruleData.get("attribute_name");
        String value = (String) ruleData.get("value");

        switch (type) {
            case "EQUALS":
                return new EqualsRule<>(attributeName, value);
            case "NOT_EQUALS":
                return new NotEqualsRule<>(attributeName, value);
            case "IN":
                String valueStr = (String) ruleData.get("values");
                String[] split = valueStr.split(",");
                Set<Object> values = new HashSet<>(Arrays.asList(split));
                return new InRule<>(attributeName, values);
                // 添加其他类型的规则解析
            default:
                throw new IllegalArgumentException("Unknown rule type: " + type);
        }
    }

    public <T> CompositeRule<T> parseCompositeRule(Map<String, Object> ruleData) {
        String attributeName = (String) ruleData.get("attribute_name");
        String combinationType = (String) ruleData.get("combination_type");

        CompositeRule<T> compositeRule =
                new CompositeRule<>(attributeName, getCombiner(combinationType));

        List<Map<String, Object>> childRulesData =
                (List<Map<String, Object>>) ruleData.get("child_rules");
        for (Map<String, Object> childRuleData : childRulesData) {
            Rule<T> rule = parseRule(childRuleData);
            compositeRule.addRule(rule);
        }

        return compositeRule;
    }

    private Predicate<List<Boolean>> getCombiner(String combinationType) {
        switch (combinationType) {
            case "AND":
                return new AndCombination();
            case "OR":
                return new OrCombination();
            default:
                throw new IllegalArgumentException("Unknown combination type: " + combinationType);
        }
    }
}
