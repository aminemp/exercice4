package com.worldline.fpl.recruitment.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Implementation of {@link TransactionRepository}
 * 
 * @author A525125
 *
 */
@Repository
public class TransactionRepositoryImpl implements TransactionRepository,
		InitializingBean {

	private List<Transaction> transactions;

	@Override
	public void afterPropertiesSet() throws Exception {
		transactions = new ArrayList<>();
		{
			Transaction transaction = new Transaction();
			transaction.setAccountId("1");
			transaction.setBalance(BigDecimal.valueOf(42.12));
			transaction.setId("1");
			transaction.setNumber("12151885120");
			transactions.add(transaction);
		}
		{
			Transaction transaction = new Transaction();
			transaction.setAccountId("1");
			transaction.setBalance(BigDecimal.valueOf(456.00));
			transaction.setId("2");
			transaction.setNumber("12151885121");
			transactions.add(transaction);
		}
		{
			Transaction transaction = new Transaction();
			transaction.setAccountId("1");
			transaction.setBalance(BigDecimal.valueOf(-12.12));
			transaction.setId("3");
			transaction.setNumber("12151885122");
			transactions.add(transaction);
		}
	}

	@Override
	public Transaction findById(String id) {
		return transactions.stream()
				.filter(transaction -> transaction.getId().equals(id))
				.findFirst().orElse(null);
	}

	@Override
	public Page<Transaction> getTransactionsByAccount(String accountId,
			Pageable p) {
		return new PageImpl<Transaction>(transactions.stream()
				.filter(t -> t.getAccountId().equals(accountId))
				.collect(Collectors.toList()));
	}

	@Override
	public Page<Transaction> getListTransactionsByAccount(String accountId) {
		return new PageImpl<Transaction>(transactions.stream()
				.filter(t -> t.getAccountId().equals(accountId))
				.collect(Collectors.toList()));
	}

	@Override
	public boolean exists(String transactionId) {
		return transactions.stream().anyMatch(
				a -> a.getId().equals(transactionId));
	}

	@Override
	public String addTransactionToAccount(String accountId, String number,
			BigDecimal balance) {

		String Id = String.valueOf(transactions.size() + 1);
		{
			Transaction transaction = new Transaction();
			transaction.setAccountId(accountId);
			transaction.setBalance(balance);
			transaction.setId(Id);
			transaction.setNumber(number);
			transactions.add(transaction);
		}
		return Id;
	}

	@Override
	public String updateTransaction(String transactionId, String accountId,
			String number, BigDecimal balance) {

		for (Transaction transaction : transactions) {

			if (transaction.getId().equals(transactionId)) {
				transaction.setAccountId(accountId);
				transaction.setBalance(balance);
				transaction.setNumber(number);
				break;

			}
		}
		return transactionId;

	}

	@Override
	public void deleteTransaction(String transactionId) {
		for (Transaction transaction : transactions) {
			if (transactionId.equals(transaction.getId())) {
				transactions.remove(transaction);
				break;
			}
		}

	}

}
