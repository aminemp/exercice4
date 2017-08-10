package com.worldline.fpl.recruitment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worldline.fpl.recruitment.json.AccountDetailsResponse;
import com.worldline.fpl.recruitment.json.AccountResponse;

/**
 * Account controller
 * 
 * @author A525125
 *
 */
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public interface AccountController {

	/**
	 * Get account list
	 * 
	 * @param p
	 *            the pageable information
	 * @return the account list
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	ResponseEntity<Page<AccountResponse>> getAccounts(
			@PageableDefault Pageable p);

	/**
	 * Get account details
	 * 
	 * @param accountId
	 *            the account id
	 * @return the account details
	 */
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	ResponseEntity<AccountDetailsResponse> getAccountDetails(
			@PathVariable("accountId") String accountId);

}
