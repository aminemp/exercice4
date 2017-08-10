package com.worldline.fpl.recruitment.dao;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Transaction repository
 * 
 * @author A525125
 *
 */
public interface TransactionRepository {

	/**
	 * Get transaction by Id
	 *
	 * @param id
	 *            id of the transaction to get
	 * @return the transaction corresponding to the given id or null
	 */
	Transaction findById(String id);

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return
	 */
	Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);

	/**
	 * Test if transaction exist
	 * 
	 * @param transactionId
	 *            the transaction id
	 *
	 * @return boolean
	 */

	boolean exists(String transactionId);

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * 
	 * @return List of transactions
	 */
	Page<Transaction> getListTransactionsByAccount(String accountId);

	/**
	 * Add Transaction to account
	 * 
	 * @param accountId
	 *            the account id
	 * @param number
	 *            the number
	 * @param balance
	 *            balance      	  
	 * @return List of transactions
	 */
	String addTransactionToAccount(String accountId, String number, BigDecimal balance);

	/**
	 * update transaction
	 * 
	 * @param transactionId
	 *            the transaction id
	 * @param accountId
	 *            the account id
	 * @param number
	 *            the number
	 * @param balance
	 *            balance      	  
	 * @return List of transactions
	 */
	
	String updateTransaction(String transactionId, String accountId,
			String number, BigDecimal balance);

	/**
	 * remove transaction
	 * 
	 * @param transactionId
	 *            the transaction id
	 *                	  
	 * @return 
	 */
	void deleteTransaction(String transactionId);
}
