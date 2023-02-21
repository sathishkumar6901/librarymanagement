package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.dto.Admin;

public interface LoginViewCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailed(String errorMessage);

}