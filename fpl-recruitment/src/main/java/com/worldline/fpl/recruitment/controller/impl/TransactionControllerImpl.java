package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.TransactionController;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import com.worldline.fpl.recruitment.service.TransactionService;

/**
 * Implementation of {@link TransactionController}
 * 
 * @author A525125
 *
 */
@Slf4j
@RestController
public class TransactionControllerImpl implements TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Override
	public ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@PathVariable("accountId") String accountId,
			@PageableDefault Pageable p) {
		Page<TransactionResponse> page = transactionService
				.getTransactionsByAccount(accountId, p);
		if (null == page || page.getTotalElements() == 0) {
			log.debug("Cannot find transaction for account {}", accountId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(page);
	}

	@Override
	public ResponseEntity<String> addTransactionToAccount(
			@PathVariable("accountId") String accountId,
			@RequestBody Transaction transaction) {
		String id = "";
		if (transaction.getNumber() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(id);
		}
		id = transactionService.addTransactionToAccount(accountId,
				transaction.getNumber(), transaction.getBalance());
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}

	@Override
	public ResponseEntity<String> updateTransaction(
			@PathVariable("accountId") String accountId,
			@PathVariable("transactionId") String transactionId,
			@RequestBody Transaction transaction) {
		if (transaction.getNumber() == null || transaction.getBalance() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
		HttpStatus status = transactionService.updateTransaction(transactionId,
				accountId, transaction.getNumber(), transaction.getBalance());
		return ResponseEntity.status(status).body(transactionId);
	}

	@Override
	public ResponseEntity<String> deleteTransaction(
			@PathVariable("accountId") String accountId,
			@PathVariable("transactionId") String transactionId) {

		HttpStatus status = transactionService.deleteTransaction(transactionId,
				accountId);
		return ResponseEntity.status(status).body(transactionId);
	}
}
