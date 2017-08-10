package com.worldline.fpl.recruitment.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Account;

/**
 * Account repository
 * 
 * @author A525125
 *
 */
public interface AccountRepository {

	/**
	 * Get account by user
	 * 
	 * @param p
	 *            the pageable information
	 * @return the account list
	 */
	Page<Account> findAll(Pageable p);

	/**
	 * Get account
	 * 
	 * @param accountId
	 *            the account id
	 * @return
	 */
	Optional<Account> findById(String accountId);

	/**
	 * Check if an account exists
	 * 
	 * @param accountId
	 *            the account id
	 * @return true if the account exists
	 */
	boolean exists(String accountId);
}
