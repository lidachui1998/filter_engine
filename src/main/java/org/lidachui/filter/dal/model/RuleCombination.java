package org.lidachui.filter.dal.model;

/**
 * RuleCombination
 *
 * @author: lihuijie
 * @date: 2024/7/4 10:10
 * @version: 1.0
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规则组合实体类
 */
@Entity
@Table(name = "rule_combination")
public class RuleCombination {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer combinationId;

  private Integer compositeRuleId;
  private Integer ruleId;
  private Integer subCompositeRuleId;

  /**
   * 获取组合ID
   * @return 组合ID
   */
  public Integer getCombinationId() {
    return combinationId;
  }

  /**
   * 设置组合ID
   * @param combinationId 组合ID
   */
  public void setCombinationId(Integer combinationId) {
    this.combinationId = combinationId;
  }

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
   * 获取子组合规则ID
   * @return 子组合规则ID
   */
  public Integer getSubCompositeRuleId() {
    return subCompositeRuleId;
  }

  /**
   * 设置子组合规则ID
   * @param subCompositeRuleId 子组合规则ID
   */
  public void setSubCompositeRuleId(Integer subCompositeRuleId) {
    this.subCompositeRuleId = subCompositeRuleId;
  }
}
