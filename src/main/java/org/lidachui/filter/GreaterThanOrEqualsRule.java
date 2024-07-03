package org.lidachui.filter;

/**
 * GreaterThanOrEqualsRule
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:25
 * @version: 1.0
 */
public class GreaterThanOrEqualsRule<T> extends Rule<T> {
    private final Comparable<Object> value;

    public GreaterThanOrEqualsRule(String attributeName, Comparable<Object> value) {
        super(attributeName);
        this.value = value;
    }

    @Override
    public boolean apply(T item) {
        Object fieldValue = getFieldValue(item);
        return value.compareTo(fieldValue) <= 0;
    }
}

