package com.evry.fs.hazelcast.demo.client;

import java.util.Map.Entry;
import java.util.Set;

import com.evry.fs.hazelcast.demo.vo.AccountVO;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazalCastClient {
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, AccountVO> map = client.getMap("accountMap");
        Set<Entry<Long, AccountVO>> entrySet = map.entrySet();
        
        entrySet.stream().forEach(entry -> {
        	System.out.println("Account iD :: "+entry.getValue().getAccountId());
        	System.out.println("Account Name :: "+entry.getValue().getAccountType());
        	System.out.println("Account Number:: "+entry.getValue().getBban());
        	System.out.println("Account Currency:: "+entry.getValue().getCurrencyCode());
        	System.out.println("Account orgid :: "+entry.getValue().getOrgId());
        });
        client.shutdown();
	}
}
