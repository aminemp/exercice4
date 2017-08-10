package com.worldline.fpl.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * Transaction entity
 * 
 * @author A525125
 *
 */
@Data
public class Transaction implements Serializable {

	private static final long serialVersionUID = 706690724306325415L;

	private String id;

	private String accountId;

	private String number;

	private BigDecimal balance;
}
