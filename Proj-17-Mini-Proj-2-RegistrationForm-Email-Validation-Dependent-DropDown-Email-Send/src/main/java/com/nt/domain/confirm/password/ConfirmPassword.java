package com.nt.domain.confirm.password;

import lombok.Data;

@Data
public class ConfirmPassword {
	
	private String tempPass;
	private String newPass;
	private String confirmPass;
	private String emailId;

}
