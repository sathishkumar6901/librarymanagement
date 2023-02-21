package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibManagementBasic;
import com.zsgs.librarymanagement.dto.Admin;
import com.zsgs.librarymanagement.setuplibrary.SetupLibraryView;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}
	
	static public void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.create();
	}
	
	public void create() {
		loginController.onCreate();
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("Welcome to Library Management System\n ------------------------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		loginController.checkCredentials(userName, password);	
	}

	@Override
	public void loginSuccess(Admin admin) {
		System.out.println("\n-->Hello " + admin.getUserName() + "<--\n");
		SetupLibraryView setupLibrary = new SetupLibraryView();
		setupLibrary.create();
	}

	@Override
	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}
}
