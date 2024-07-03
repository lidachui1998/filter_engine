package org.lidachui.filter;

import java.util.*;
import java.util.function.Predicate;

/**
 * OrCombination
 *
 * @author: lihuijie
 * @date: 2024/7/3 21:27
 * @version: 1.0
 */
public class OrCombination implements Predicate<List<Boolean>> {
    @Override
    public boolean test(List<Boolean> results) {
        return results.stream().anyMatch(Boolean::booleanValue);
    }
}