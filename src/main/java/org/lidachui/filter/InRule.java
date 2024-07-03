package org.lidachui.filter;

import java.util.*;

/**
 * InRule
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:56
 * @version: 1.0
 */

public class InRule<T> extends Rule<T> {
    private final Set<Object> values;

    public InRule(String attributeName, Set<Object> values) {
        super(attributeName);
        this.values = values;
    }

    @Override
    public boolean apply(T item) {
        Object fieldValue = getFieldValue(item);
        return values.contains(fieldValue);
    }
}