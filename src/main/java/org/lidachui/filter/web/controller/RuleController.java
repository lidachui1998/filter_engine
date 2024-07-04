package org.lidachui.filter.web.controller;

/**
 * RuleController
 *
 * @author: lihuijie
 * @date: 2024/7/4 10:36
 * @version: 1.0
 */
import org.lidachui.filter.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 规则控制器
 */
@RestController
@RequestMapping("/rules")
public class RuleController {
  @Autowired
  private RuleService ruleService;

  /**
   * 保存规则接口
   * @return 成功信息
   */
  @PostMapping("/save")
  public ResponseEntity<String> saveRules() {
    ruleService.saveRules();
    return ResponseEntity.ok("Rules saved successfully.");
  }

  /**
   * 解析规则接口
   * @return 成功信息
   */
  @GetMapping("/parse")
  public ResponseEntity<String> parseRules() {
    ruleService.parseRules();
    return ResponseEntity.ok("Rules parsed successfully.");
  }
}
