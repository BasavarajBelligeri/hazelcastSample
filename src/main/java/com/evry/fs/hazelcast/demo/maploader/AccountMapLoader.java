package com.evry.fs.hazelcast.demo.maploader;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.evry.fs.hazelcast.demo.dao.AccountDao;
import com.evry.fs.hazelcast.demo.entity.Account;
import com.evry.fs.hazelcast.demo.vo.AccountVO;
import com.hazelcast.core.MapLoader;

public class AccountMapLoader implements MapLoader<Long, AccountVO> {
	private AccountDao accountDao;

	public AccountMapLoader(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public AccountVO load(Long accountKey) {
		return convertAccountVo( accountDao.readAccount(accountKey));
	}

	public Map<Long, AccountVO> loadAll(Collection<Long> accountKey) {
		List<Account> accounts = accountDao.fecthAllAccount(accountKey);
		return accounts.stream().map(this::convertAccountVo).collect(Collectors.toMap(AccountVO::getAccountId, account -> account));
	}

	public Iterable<Long> loadAllKeys() {
		Collection<Long> accountKeys = accountDao.readAllAccountKeys();
		return accountKeys;
	}
	
	private AccountVO convertAccountVo(Account account) {
		return AccountVO.builder().accountId(account.getAccountId())
				                  .orgId(account.getOrgId())
				                  .accountType(account.getAccountType())
				                  .bban(account.getBban())
				                  .amount(account.getAmount())
				                  .currencyCode(account.getCurrencyCode())
				                  .customerId(account.getCustomerId())
				                  .build();
	}

}
