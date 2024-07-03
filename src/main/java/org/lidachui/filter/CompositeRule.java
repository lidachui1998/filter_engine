package org.lidachui.filter;

import java.util.*;
import java.util.function.Predicate;

/**
 * CompositeRule
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:26
 * @version: 1.0
 */
public class CompositeRule<T> extends Rule<T> {
    private final List<Rule<T>> rules = new ArrayList<>();
    private final Predicate<List<Boolean>> combiner;

    public CompositeRule(String attributeName, Predicate<List<Boolean>> combiner) {
        super(attributeName);
        this.combiner = combiner;
    }

    public void addRule(Rule<T> rule) {
        rules.add(rule);
    }

    @Override
    public boolean apply(T item) {
        List<Boolean> results = new ArrayList<>();
        for (Rule<T> rule : rules) {
            results.add(rule.apply(item));
        }
        return combiner.test(results);
    }
}
