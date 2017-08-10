package com.worldline.fpl.recruitment.json;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Account details json representation
 * 
 * @author A525125
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccountDetailsResponse extends AccountResponse implements
		Serializable {

	private static final long serialVersionUID = -6427772324577115079L;

	@NotNull
	private Date creationDate;

	@NotNull
	private boolean active;
}
