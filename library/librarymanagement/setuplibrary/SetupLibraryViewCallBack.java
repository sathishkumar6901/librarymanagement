package com.zsgs.librarymanagement.setuplibrary;

import com.zsgs.librarymanagement.dto.Library;

interface SetupLibraryViewCallBack {

	void libraryAddedSuccessfully(Library library);

	void onLibraryExists(Library library);

	void setupNewLibrary();

	void onLibraryCreated(Library library);
}
