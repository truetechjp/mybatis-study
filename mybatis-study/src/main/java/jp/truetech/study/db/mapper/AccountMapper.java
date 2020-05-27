package jp.truetech.study.db.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;

import jp.truetech.study.db.entity.Account;

@Mapper
public interface AccountMapper {

	public void append(Account account);
	public Account findById(long id);
	public void update(Account account);
	public void updateName(long id, String name, LocalDateTime updateTime);
}
