package com.evry.fs.hazelcast.demo.vo;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import com.hazelcast.core.standalone.AllTest.Customer;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AccountVO  implements Serializable{

	private Long accountId;

	private String orgId;

	private String bban;

	private String accountType;

	private BigDecimal amount;

	private String currencyCode;

	private Long customerId;


/*	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeLong(accountId);
		out.writeObject(orgId);
		out.writeObject(bban);
		out.writeObject(accountType);
		out.writeObject(amount);
		out.writeObject(currencyCode);
		out.writeLong(customerId);
	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		accountId=in.readLong();
		orgId=in.readObject();
		bban=in.readObject();
		accountType=in.readObject();
		amount=in.readObject();
		currencyCode=in.readObject();
		customerId=in.readLong();
	}

	@Override
	public int getFactoryId() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 1000;
	}*/

	
}
