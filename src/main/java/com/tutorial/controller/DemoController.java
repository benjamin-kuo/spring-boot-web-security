package com.tutorial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.tutorial.persistence.entity.AccountEntity;
import com.tutorial.service.AccountService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class DemoController {

  @Autowired
  AccountService accountService;

  @GetMapping("{id}")
  public ResponseEntity<String> hello(@PathVariable("id") String hi){
    return ResponseEntity.ok("hello ".concat(hi));
  }

  /**
   * expected 200 OK
   * @param account account info
   */
  @PostMapping("account")
  public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity account){
    return ResponseEntity.ok(accountService.createAccount(account));
  }

  /**
   * expected 200 OK
   * @param id id
   */
  @GetMapping("account/{id}")
  public ResponseEntity<AccountEntity> getAccount(@PathVariable Long id){
    return ResponseEntity.ok(accountService.getAccount(id));
  }

  /**
   * @return expected 403 Forbidden
   */
  @GetMapping("accounts")
  public ResponseEntity<List<AccountEntity>> getAccounts(){
    return ResponseEntity.ok(accountService.getAccounts());
  }

}
