package org.lidachui.filter.core.rules;

import org.lidachui.filter.core.Rule;

/**
 * IsNullRule
 *
 * @author: lihuijie
 * @date: 2024/7/3 23:23
 * @version: 1.0
 */
public class IsNullRule<T> extends Rule<T> {
    public IsNullRule(String attributeName) {
        super(attributeName);
    }

    @Override
    public boolean apply(T item) {
        Object fieldValue = getFieldValue(item);
        return isNUll(fieldValue);
    }

    private boolean isNUll(Object fieldValue) {
        return fieldValue == null || fieldValue == "";
    }
}
