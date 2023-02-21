package com.zsgs.librarymanagement.setuplibrary;

import com.zsgs.librarymanagement.dto.Library;
import com.zsgs.librarymanagement.setuplibrary.SetupLibraryModel.SetupLibraryModelControllerCallBack;

class SetupLibraryController implements SetupLibraryControllerCallBack, SetupLibraryModelControllerCallBack {
	private SetupLibraryViewCallBack setupLibraryView;
	private SetupLibraryModelCallBack setupLibraryModel;

	public SetupLibraryController(SetupLibraryViewCallBack setupLibraryView) {
		this.setupLibraryView = setupLibraryView;
		this.setupLibraryModel = new SetupLibraryModel(this);
	}

	@Override
	public void onCreate() {
		setupLibraryModel.onCreate();
	}

	@Override
	public void addNewLibrary(Library library) {
		setupLibraryModel.addNewLibrary(library);
	}
	
	@Override
	public void updateLibraryDetails(Library library) {
		setupLibraryModel.updateLibraryDetails(library);
	}

	@Override
	public void onLibraryExist(Library library) {
		setupLibraryView.onLibraryExists(library);
	}

	@Override
	public void setupNewLibrary() {
		setupLibraryView.setupNewLibrary();
	}

	@Override
	public void onLibraryCreated(Library library) {
		setupLibraryView.onLibraryCreated(library);
	}

}
