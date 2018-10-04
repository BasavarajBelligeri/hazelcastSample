package com.evry.fs.hazelcast.demo;

import com.evry.fs.hazelcast.demo.server.HazalCastServer;
import com.evry.fs.hazelcast.demo.vo.AccountVO;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class App 
{
	public static void main( String[] args )
    {
        HazelcastInstance hazelcastInstance = new HazalCastServer().init();
        IMap<Long, AccountVO> map = hazelcastInstance.getMap("accountMap");
        map.loadAll(true);
        int size = map.entrySet().size();
        System.out.println("Map Size:::::::::: "+size);
    }
}
