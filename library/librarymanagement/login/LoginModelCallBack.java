package com.zsgs.librarymanagement.login;

public interface LoginModelCallBack {

	void checkCredentials(String userName, String password);

	void onCreate();

}