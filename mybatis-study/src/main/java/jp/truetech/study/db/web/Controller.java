package jp.truetech.study.db.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.truetech.study.db.entity.Account;
import jp.truetech.study.db.mapper.AccountMapper;

@RestController 
public class Controller {

	@Autowired
	private AccountMapper accountMapper;

	@RequestMapping("/find")
	public Account find(@RequestParam(defaultValue = "#{NULL}") long id) {
		Account account = accountMapper.findById(id);
		return account;
	}
	
	@RequestMapping("/append")
	public Account append(
			@RequestParam String name, 
			@RequestParam @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate birthday) {
		LocalDateTime currentTimestamp = LocalDateTime.now();
		Account account = new Account();
		account.setName(name);
		account.setBirthday(birthday);
		account.setInsertTime(currentTimestamp);
		account.setUpdateTime(currentTimestamp);
		accountMapper.append(account);
		return account;
	}
	
	@RequestMapping("/updateName")
	public Account updateName(@RequestParam long id, @RequestParam String name) {
		LocalDateTime currentTimestamp = LocalDateTime.now();
		accountMapper.updateName(id, name, currentTimestamp);
		return accountMapper.findById(id);
	}
}
