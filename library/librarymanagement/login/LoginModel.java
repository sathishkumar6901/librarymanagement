package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.dto.Admin;
import com.zsgs.librarymanagement.repository.LibraryRepository;

public class LoginModel implements LoginModelCallBack{

	private LoginModelControlerCallBack loginController;
	
	public LoginModel(LoginModelControlerCallBack loginController) {
		this.loginController = loginController;
	}

	@Override
	public void onCreate() {
		LibraryRepository.getInstance().removeCurrentUser();
	}
	
	@Override
	public void checkCredentials(String userName, String password) {
		boolean canLogin = false;
		Admin adminUser = LibraryRepository.getInstance().checkValidUser(userName,password);
		if (adminUser !=null) {
			loginController.loginSuccess(adminUser);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface LoginModelControlerCallBack {

		void loginSuccess(Admin adminUser);

		void loginFailiure(String string);

	}

}
