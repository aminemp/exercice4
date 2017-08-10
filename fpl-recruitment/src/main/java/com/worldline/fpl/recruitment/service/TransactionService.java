package com.worldline.fpl.recruitment.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;
import com.worldline.fpl.recruitment.json.TransactionResponse;

/**
 * Transaction service
 * 
 * @author A525125
 *
 */
@Service
public class TransactionService {

	private AccountService accountService;

	private TransactionRepository transactionRepository;

	@Autowired
	public TransactionService(AccountService accountService,
			TransactionRepository transactionRepository) {
		this.accountService = accountService;
		this.transactionRepository = transactionRepository;
	}

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable object
	 * @return
	 */
	public Page<TransactionResponse> getTransactionsByAccount(String accountId,
			Pageable p) {
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
					"Account doesn't exist");
		}
		return new PageImpl<TransactionResponse>(transactionRepository
				.getTransactionsByAccount(accountId, p).getContent().stream()
				.map(this::map).collect(Collectors.toList()));
	}

	/**
	 * Map {@link Transaction} to {@link TransactionResponse}
	 * 
	 * @param transaction
	 * @return
	 */
	private TransactionResponse map(Transaction transaction) {
		TransactionResponse result = new TransactionResponse();
		result.setBalance(transaction.getBalance());
		result.setId(transaction.getId());
		result.setNumber(transaction.getNumber());
		return result;
	}

	/**
	 * Check if a transaction exists
	 * 
	 * @param transactionId
	 *            the transaction id
	 * @return true if the transaction exists
	 */
	public boolean isTransactionExist(String transactionId) {
		return transactionRepository.exists(transactionId);
	}

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * @return
	 */
	public List<Transaction> getTransactionsByAccount(String accountId) {
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
					"Account doesn't exist");
		}
		return new ArrayList<Transaction>(transactionRepository
				.getListTransactionsByAccount(accountId).getContent());
	}

	/**
	 * Add transaction to account
	 * 
	 * @param accountId
	 *            the account id
	 * @param number
	 *            the transaction number
	 * @param balance
	 *            the transaction balance
	 * @return
	 */

	public String addTransactionToAccount(String accountId, String number,
			BigDecimal balance) {
		if (accountService.isAccountExist(accountId)) {
			return transactionRepository.addTransactionToAccount(accountId,
					number, balance);
		} else {
			throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
					"Account doesn't exist");
		}
	}

	/**
	 * update transaction
	 * 
	 * @param accountId
	 *            the account id
	 * @param number
	 *            the transaction number
	 * @param balance
	 *            the transaction balance
	 * @return
	 */

	public HttpStatus updateTransaction(String transactionId, String accountId,
			String number, BigDecimal balance) {
		if (!accountService.isAccountExist(accountId)) {
			throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
					"Account doesn't exist");
		} else if (!isTransactionExist(transactionId)) {
			throw new ServiceException(ErrorCode.NOT_FOUND_TRANSACTION,
					"Transaction doesn't exist");
		} else if (!getTransactionsByAccount(accountId).contains(
				transactionRepository.findById(transactionId))) {
			return HttpStatus.FORBIDDEN;
		} else {
			transactionRepository.updateTransaction(transactionId, accountId,
					number, balance);
			return HttpStatus.NO_CONTENT;
		}
	}

	public HttpStatus deleteTransaction(String transactionId, String accountId) {

		if (!isTransactionExist(transactionId)) {
			throw new ServiceException(ErrorCode.NOT_FOUND_TRANSACTION,
					"Transaction doesn't exist");
		} else if (!getTransactionsByAccount(accountId).contains(
				transactionRepository.findById(transactionId))) {
			return HttpStatus.FORBIDDEN;
		}
		transactionRepository.deleteTransaction(transactionId);
		return HttpStatus.NO_CONTENT;
	}
}
