package org.lidachui.filter;

import java.util.*;
import java.util.function.Predicate;
import org.lidachui.filter.condition.AndCombination;
import org.lidachui.filter.condition.CompositeRule;
import org.lidachui.filter.condition.OrCombination;
import org.lidachui.filter.core.rules.EqualsRule;
import org.lidachui.filter.core.rules.InRule;
import org.lidachui.filter.core.rules.IsNotNullRule;
import org.lidachui.filter.core.rules.IsNullRule;
import org.lidachui.filter.core.rules.NotEqualsRule;
import org.lidachui.filter.dal.model.Rule;

/**
 * RuleParser
 *
 * @author: lihuijie
 * @date: 2024/7/3 23:53
 * @version: 1.0
 */
public class RuleParser {

    public <T> org.lidachui.filter.core.Rule<T> parseRule(Rule rule) {
        String ruleType = rule.getRuleType();
        String attributeName = rule.getAttributeName();
        String value = rule.getValue();

        switch (ruleType) {
            case "EQUALS":
                return new EqualsRule<>(attributeName, value);
            case "NOT_EQUALS":
                return new NotEqualsRule<>(attributeName, value);
            case "IN":
                String[] split = value.split(",");
                Set<Object> values = new HashSet<>(Arrays.asList(split));
                return new InRule<>(attributeName, values);
            case "IS_NULL":
                return new IsNullRule<>(attributeName);
            case "IS_NOT_NULL":
                return new IsNotNullRule<>(attributeName);
            default:
                throw new IllegalArgumentException("Unknown rule type: " + ruleType);
        }
    }

    public <T> CompositeRule<T> parseCompositeRule(Map<String, Object> ruleData) {
      return null;
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
