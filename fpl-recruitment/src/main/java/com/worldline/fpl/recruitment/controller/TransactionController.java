package com.worldline.fpl.recruitment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.json.TransactionResponse;

/**
 * Transaction controller
 * 
 * @author A525125
 *
 */
@RequestMapping(value = "/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TransactionController {

	/**
	 * Get transaction list by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return the transaction list
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@PathVariable("accountId") String accountId,
			@PageableDefault Pageable p);

	/**
	 * Add transaction to an account
	 * 
	 * @param accountId
	 *            the account id
	 * @param transaction object
	 *            transaction data
	 * 
	 * @return the transaction id
	 */

	@RequestMapping(value = "", method = RequestMethod.POST)
	ResponseEntity<String> addTransactionToAccount(
			@PathVariable("accountId") String accountId,
			@RequestBody Transaction tr);

	/**
	 * Update transaction
	 * 
	 * @param accountId
	 *            the account id
	 * @param transactionId
	 *            the transaction id
	 * @param transaction
	 *            transaction
	 * @return the status
	 */
	@RequestMapping(value = "/{transactionId}", method = RequestMethod.PUT)
	ResponseEntity<String> updateTransaction(
			@PathVariable("accountId") String accountId,
			@PathVariable("transactionId") String transactionId,
			@RequestBody Transaction transaction);

	/**
	 * delete transaction
	 * 
	 * @param accountId
	 *            the account id
	 * @param transactionId
	 *            the transaction id
	 * @param transaction
	 *            transaction
	 * @return the status
	 */
	@RequestMapping(value = "/{transactionId}", method = RequestMethod.DELETE)
	ResponseEntity<String> deleteTransaction(String transactionId,
			@PathVariable("accountId") String accountId);

}
