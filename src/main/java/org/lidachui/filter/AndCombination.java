package org.lidachui.filter;

import java.util.*;
import java.util.function.Predicate;

/**
 * AndCombination
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:26
 * @version: 1.0
 */
public class AndCombination implements Predicate<List<Boolean>> {
    @Override
    public boolean test(List<Boolean> results) {
        return results.stream().allMatch(Boolean::booleanValue);
    }
}