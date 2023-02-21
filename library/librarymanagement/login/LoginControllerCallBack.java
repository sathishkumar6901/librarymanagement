package com.zsgs.librarymanagement.login;

public interface LoginControllerCallBack {

	void checkCredentials(String userName, String password);

	void onCreate();
}
