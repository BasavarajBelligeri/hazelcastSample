
package com.evry.fs.hazelcast.demo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.evry.fs.hazelcast.demo.entity.Account;

public class AccountDaoImpl implements AccountDao {

	public Account readAccount(Long accountKey) {
		EntityManager entityManager = EntityManageProvider.provideEntityManager();
		Account account = entityManager.find(Account.class, accountKey);
		return account;
	}

	public List<Account> fecthAllAccount(Collection<Long> keys) {
		EntityManager entityManager = EntityManageProvider.provideEntityManager();
		Query readAllAccounts = entityManager.createNamedQuery("read.all.account");
		readAllAccounts.setParameter("accountId", keys);
		List<Account> resultList = readAllAccounts.getResultList();
		return resultList;
	}

	public Collection<Long> readAllAccountKeys() {
		EntityManager entityManager = EntityManageProvider.provideEntityManager();
		Query readAllAccounts = entityManager.createNamedQuery("read.all");
		List<Long> keys = readAllAccounts.getResultList();
		return keys;
	}

}
