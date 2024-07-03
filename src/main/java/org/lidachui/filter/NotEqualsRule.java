package org.lidachui.filter;

/**
 * NotEqualsRule
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:25
 * @version: 1.0
 */
public class NotEqualsRule<T> extends Rule<T> {
    private final Object value;

    public NotEqualsRule(String attributeName, Object value) {
        super(attributeName);
        this.value = value;
    }

    @Override
    public boolean apply(T item) {
        return !value.equals(getFieldValue(item));
    }
}