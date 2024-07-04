package org.lidachui.filter.dal.model;

/**
 * Rule
 *
 * @author: lihuijie
 * @date: 2024/7/4 9:59
 * @version: 1.0
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规则实体类
 */
@Entity
@Table(name = "rule")
public class Rule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ruleId;

  private String attributeName;
  private String ruleType;
  private String value;

  /**
   * 获取规则ID
   * @return 规则ID
   */
  public Integer getRuleId() {
    return ruleId;
  }

  /**
   * 设置规则ID
   * @param ruleId 规则ID
   */
  public void setRuleId(Integer ruleId) {
    this.ruleId = ruleId;
  }

  /**
   * 获取属性名称
   * @return 属性名称
   */
  public String getAttributeName() {
    return attributeName;
  }

  /**
   * 设置属性名称
   * @param attributeName 属性名称
   */
  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  /**
   * 获取规则类型
   * @return 规则类型
   */
  public String getRuleType() {
    return ruleType;
  }

  /**
   * 设置规则类型
   * @param ruleType 规则类型
   */
  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }

  /**
   * 获取规则值
   * @return 规则值
   */
  public String getValue() {
    return value;
  }

  /**
   * 设置规则值
   * @param value 规则值
   */
  public void setValue(String value) {
    this.value = value;
  }
}
