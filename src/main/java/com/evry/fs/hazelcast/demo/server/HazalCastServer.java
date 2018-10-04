package com.evry.fs.hazelcast.demo.server;

import com.evry.fs.hazelcast.demo.dao.AccountDaoImpl;
import com.evry.fs.hazelcast.demo.maploader.AccountMapLoader;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazalCastServer {

	public HazelcastInstance init() {
		return Hazelcast.newHazelcastInstance(createNewConfig("accountMap"));
	}

	private  Config createNewConfig(String mapName) {
		
		XmlConfigBuilder configBuilder = new XmlConfigBuilder();
        Config config = configBuilder.build();
        NetworkConfig networkConfig = config.getNetworkConfig();
        networkConfig.getJoin().getMulticastConfig().setEnabled(true);
        MapConfig mapConfig = config.getMapConfig(mapName);
        MapStoreConfig mapStoreConfig = mapConfig.getMapStoreConfig();
        mapStoreConfig.setImplementation(new AccountMapLoader(new AccountDaoImpl()));
        mapStoreConfig.setEnabled(true);
        mapConfig.setMapStoreConfig(mapStoreConfig);
        config.addMapConfig(mapConfig);
		return config;
	}
}
