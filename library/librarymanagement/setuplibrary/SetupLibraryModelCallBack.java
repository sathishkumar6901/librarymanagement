package com.zsgs.librarymanagement.setuplibrary;

import com.zsgs.librarymanagement.dto.Library;

interface SetupLibraryModelCallBack {

	void onCreate();

	void updateLibraryDetails(Library library);

	void addNewLibrary(Library library);
	
}
