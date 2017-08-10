package com.worldline.fpl.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * Account entity
 * 
 * @author A525125
 *
 */
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = -3548441891975414771L;

	private String id;

	private String number;

	private String type;

	private BigDecimal balance;

	private Date creationDate;

	private boolean isActive;
}
