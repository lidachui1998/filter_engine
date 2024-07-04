package org.lidachui.filter.dal.model;

/**
 * CompositeRule
 *
 * @author: lihuijie
 * @date: 2024/7/4 10:09
 * @version: 1.0
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 组合规则实体类
 */
@Entity
@Table(name = "composite_rule")
public class CompositeRule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer compositeRuleId;

  private String combinationType;

  /**
   * 获取组合规则ID
   * @return 组合规则ID
   */
  public Integer getCompositeRuleId() {
    return compositeRuleId;
  }

  /**
   * 设置组合规则ID
   * @param compositeRuleId 组合规则ID
   */
  public void setCompositeRuleId(Integer compositeRuleId) {
    this.compositeRuleId = compositeRuleId;
  }

  /**
   * 获取组合类型
   * @return 组合类型
   */
  public String getCombinationType() {
    return combinationType;
  }

  /**
   * 设置组合类型
   * @param combinationType 组合类型
   */
  public void setCombinationType(String combinationType) {
    this.combinationType = combinationType;
  }
}
