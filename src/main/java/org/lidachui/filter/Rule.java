package org.lidachui.filter;

import java.lang.reflect.Field;

/**
 * Rule
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:24
 * @version: 1.0
 */
public abstract class Rule<T> {
    protected String attributeName;

    public Rule(String attributeName) {
        this.attributeName = attributeName;
    }

    protected Object getFieldValue(T item) {
        try {
            Field field = item.getClass().getDeclaredField(attributeName);
            field.setAccessible(true);
            return field.get(item);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAttributeName() {
        return attributeName;
    }

    public abstract boolean apply(T item);
}
