package com.evry.fs.hazelcast.demo.dao;

import java.util.Collection;
import java.util.List;

import com.evry.fs.hazelcast.demo.entity.Account;

public interface AccountDao {

	Account readAccount(Long accountKey);
	
	List<Account> fecthAllAccount(Collection<Long> keys);
	
	Collection<Long> readAllAccountKeys();
		
}
