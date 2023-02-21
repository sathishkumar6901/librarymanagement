package com.zsgs.librarymanagement.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.zsgs.librarymanagement.dto.Admin;
import com.zsgs.librarymanagement.dto.Book;
import com.zsgs.librarymanagement.dto.Credentials;
import com.zsgs.librarymanagement.dto.Library;
import com.zsgs.librarymanagement.dto.User;

public class LibraryRepository {
	private static LibraryRepository libraryDbInstance;

	private List<Credentials> adminCredentials = new ArrayList<Credentials>();
	private Library library = null;
	private List<User> user = new ArrayList<User>();
	private List<Book> books = new ArrayList<Book>();
	private Admin currentAdminUser = null;

	private LibraryRepository() {

	}

	public static LibraryRepository getInstance() {
		if (libraryDbInstance == null) {
			libraryDbInstance = new LibraryRepository();
			libraryDbInstance.initialSetup();
		}
		return libraryDbInstance;
	}

	private void initialSetup() {
		// Adding Admin details to the list
		adminCredentials.add(new Credentials("0001", "admin", "ZSGS"));
		adminCredentials.add(new Credentials("0002", "bala", "ZSGS"));
	}

	public Admin checkValidUser(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	public Library getLibrary() {
		return library;
	}
	
	public void upsertLibrary(Library library) {
		this.library = library;
	}

	public void addBook(String bookName) {
//		books.add(bookName);
//		insertQuery
	}

	public void deleteBook(String bookName) {
//		books.remove(bookName);
		// DeleteQuery
	}

	public List<Book> searchBooks(String keyword) {
		// filter logic
		// search Query
		return books;
	}

	public void removeCurrentUser() {
		currentAdminUser = null;
	}

}
