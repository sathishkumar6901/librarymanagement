package com.zsgs.librarymanagement.setuplibrary;

import com.zsgs.librarymanagement.dto.Library;

public interface SetupLibraryControllerCallBack {

	void onCreate();

	void addNewLibrary(Library library);
	
	void updateLibraryDetails(Library library);
}