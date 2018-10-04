package com.evry.fs.hazelcast.demo.entity;


import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hazelcast.core.standalone.AllTest.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JFR_ACCOUNT")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(value = {@NamedQuery(name="read.all",query="SELECT a.accountId FROM Account a"),
					   @NamedQuery(name="read.all.account",query="SELECT a FROM Account a where a.accountId in (:accountId)")})
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    @SequenceGenerator(allocationSize = 50, sequenceName = "seq_account", name = "seq_account")
    private Long accountId;

    @Column(name = "org_id", nullable = false)
   
    private String orgId;

    @Column(name = "bban", nullable = false)
    private String bban;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;
}
