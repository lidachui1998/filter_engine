package org.lidachui.filter.core.rules;

import org.lidachui.filter.core.Rule;

/**
 * IsNotNullRule
 *
 * @author: lihuijie
 * @date: 2024/7/4 16:11
 * @version: 1.0
 */
public class IsNotNullRule<T> extends Rule<T> {


    public IsNotNullRule(String attributeName) {
      super(attributeName);
    }

    @Override
    public boolean apply(T item) {
      Object fieldValue = getFieldValue(item);
      return isNotNUll(fieldValue);
    }

    private boolean isNotNUll(Object fieldValue) {
      return fieldValue != null && !"".equals(fieldValue) ;
    }

}
