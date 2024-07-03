package org.lidachui.filter;

/**
 * RuleEngine
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:36
 * @version: 1.0
 */
import java.util.List;
import java.util.stream.Collectors;

public class RuleEngine<T> {
    private final CompositeRule<T> rule;

    public RuleEngine(CompositeRule<T> rule) {
        this.rule = rule;
    }

    public List<T> filter(List<T> items) {
        return items.stream().filter(rule::apply).collect(Collectors.toList());
    }
}
