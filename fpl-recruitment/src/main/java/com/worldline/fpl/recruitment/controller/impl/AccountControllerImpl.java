package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.AccountController;
import com.worldline.fpl.recruitment.json.AccountDetailsResponse;
import com.worldline.fpl.recruitment.json.AccountResponse;
import com.worldline.fpl.recruitment.service.AccountService;

/**
 * Implementation of {@link AccountController}
 * 
 * @author A525125
 *
 */
@Slf4j
@RestController
public class AccountControllerImpl implements AccountController {

	private AccountService accountService;

	@Autowired
	public AccountControllerImpl(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public ResponseEntity<Page<AccountResponse>> getAccounts(
			@PageableDefault Pageable p) {
		Page<AccountResponse> page = accountService.getAccounts(p);
		if (null == page || page.getTotalElements() == 0) {
			log.debug("Cannot find account");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(page);
	}

	@Override
	public ResponseEntity<AccountDetailsResponse> getAccountDetails(
			@PathVariable("accountId") String accountId) {
		return ResponseEntity.ok().body(
				accountService.getAccountDetails(accountId));
	}

}
