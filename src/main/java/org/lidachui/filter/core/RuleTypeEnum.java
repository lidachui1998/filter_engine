package org.lidachui.filter.core;


/**
 * RuleTypeEnum
 *
 * @author: lihuijie
 * @date: 2024/7/4 16:26
 * @version: 1.0
 */
public enum RuleTypeEnum {
    /** 等于 */
    EQUALS("Equals", "="),
    /** 不相等 */
    NOT_EQUALS("NotEquals", "!="),
    /** 为空 */
    IS_NULL("IsNull", "null"),
    /** 不为空 */
    IS_NOT_NULL("IsNotNull", "notNull"),
    /** 包含 */
    IN("In", "in");

    private final String ruleType;

    private final String ruleFlag;

    RuleTypeEnum(String ruleType, String ruleFlag) {
        this.ruleType = ruleType;
        this.ruleFlag = ruleFlag;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getRuleFlag() {
        return ruleFlag;
    }
}
