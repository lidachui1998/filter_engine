package org.lidachui.filter.service;

import java.util.List;
import org.lidachui.filter.dal.mapper.CompositeRuleMapper;
import org.lidachui.filter.dal.mapper.RuleCombinationMapper;
import org.lidachui.filter.dal.mapper.RuleMapper;
import org.lidachui.filter.dal.model.CompositeRule;
import org.lidachui.filter.dal.model.Rule;
import org.lidachui.filter.dal.model.RuleCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * RuleService
 *
 * @author: lihuijie
 * @date: 2024/7/4 10:25
 * @version: 1.0
 */
@Service
public class RuleService {
  @Autowired
  private RuleMapper ruleMapper;

  @Autowired
  private CompositeRuleMapper compositeRuleMapper;

  @Autowired
  private RuleCombinationMapper ruleCombinationMapper;

  @Transactional
  public void saveRules() {
    // 插入规则
    Rule rule1 = new Rule();
    rule1.setAttributeName("marketCode");
    rule1.setRuleType("Equals");
    rule1.setValue("A");
    ruleMapper.insert(rule1);

    Rule rule2 = new Rule();
    rule2.setAttributeName("paymentCode");
    rule2.setRuleType("NotEquals");
    rule2.setValue("P1");
    ruleMapper.insert(rule2);

    Rule rule3 = new Rule();
    rule3.setAttributeName("sourceCode");
    rule3.setRuleType("Equals");
    rule3.setValue("Y");
    ruleMapper.insert(rule3);

    Rule rule4 = new Rule();
    rule4.setAttributeName("sourceCode");
    rule4.setRuleType("IsNull");
    ruleMapper.insert(rule4);

    // 插入 AND 组合规则
    CompositeRule andRule = new CompositeRule();
    andRule.setCombinationType("AND");
    compositeRuleMapper.insert(andRule);

    RuleCombination andCombination1 = new RuleCombination();
    andCombination1.setCompositeRuleId(andRule.getCompositeRuleId());
    andCombination1.setRuleId(rule1.getRuleId());
    ruleCombinationMapper.insert(andCombination1);

    RuleCombination andCombination2 = new RuleCombination();
    andCombination2.setCompositeRuleId(andRule.getCompositeRuleId());
    andCombination2.setRuleId(rule2.getRuleId());
    ruleCombinationMapper.insert(andCombination2);

    // 插入 OR 组合规则
    CompositeRule orRule = new CompositeRule();
    orRule.setCombinationType("OR");
    compositeRuleMapper.insert(orRule);

    RuleCombination orCombination1 = new RuleCombination();
    orCombination1.setCompositeRuleId(orRule.getCompositeRuleId());
    orCombination1.setSubCompositeRuleId(andRule.getCompositeRuleId());
    ruleCombinationMapper.insert(orCombination1);

    RuleCombination orCombination2 = new RuleCombination();
    orCombination2.setCompositeRuleId(orRule.getCompositeRuleId());
    orCombination2.setRuleId(rule3.getRuleId());
    ruleCombinationMapper.insert(orCombination2);

    RuleCombination orCombination3 = new RuleCombination();
    orCombination3.setCompositeRuleId(orRule.getCompositeRuleId());
    orCombination3.setRuleId(rule4.getRuleId());
    ruleCombinationMapper.insert(orCombination3);
  }

  public void parseRules() {
    List<CompositeRule> compositeRules = compositeRuleMapper.selectAll();
    for (CompositeRule compositeRule : compositeRules) {
      parseCompositeRule(compositeRule);
    }
  }

  private void parseCompositeRule(CompositeRule compositeRule) {
    Example example = new Example(RuleCombination.class);
    example.createCriteria().andEqualTo("compositeRuleId", compositeRule.getCompositeRuleId());
    List<RuleCombination> combinations = ruleCombinationMapper.selectByExample(example);
    for (RuleCombination combination : combinations) {
      if (combination.getRuleId() != null) {
        Rule rule = ruleMapper.selectByPrimaryKey(combination.getRuleId());
        // 解析单个规则的逻辑

      }
      if (combination.getSubCompositeRuleId() != null) {
        CompositeRule subCompositeRule = compositeRuleMapper.selectByPrimaryKey(combination.getSubCompositeRuleId());
        parseCompositeRule(subCompositeRule);
      }
    }
  }


}
