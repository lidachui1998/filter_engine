package org.lidachui.filter.core;

import java.util.List;
import java.util.stream.Collectors;
import org.lidachui.filter.condition.CompositeRule;

/**
 * RuleEngine
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:36
 * @version: 1.0
 */
public class RuleEngine<T> {
    private final CompositeRule<T> rule;

    public RuleEngine(CompositeRule<T> rule) {
        this.rule = rule;
    }

    public List<T> filter(List<T> items) {
        return items.stream().filter(rule::apply).collect(Collectors.toList());
    }
}
