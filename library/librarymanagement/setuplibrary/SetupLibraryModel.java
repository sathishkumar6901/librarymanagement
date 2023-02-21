package com.zsgs.librarymanagement.setuplibrary;

import com.zsgs.librarymanagement.dto.Library;
import com.zsgs.librarymanagement.repository.LibraryRepository;

public class SetupLibraryModel implements SetupLibraryModelCallBack {
	private SetupLibraryModelControllerCallBack setupLibraryController;

	public SetupLibraryModel(SetupLibraryModelControllerCallBack setupLibraryController) {
		this.setupLibraryController = setupLibraryController;
	}

	@Override
	public void onCreate() {
		Library library = LibraryRepository.getInstance().getLibrary();
		if(library == null) {
			setupLibraryController.setupNewLibrary();	
		}else {
			setupLibraryController.onLibraryExist(library);
		}
	}

	@Override
	public void addNewLibrary(Library library) {
		LibraryRepository.getInstance().upsertLibrary(library);
		setupLibraryController.onLibraryCreated(library);
	}
	
	@Override
	public void updateLibraryDetails(Library library) {
		LibraryRepository.getInstance().upsertLibrary(library);
	}
	
	interface SetupLibraryModelControllerCallBack{

		void onLibraryExist(Library library);

		void setupNewLibrary();
		
		void onLibraryCreated(Library library);
	}

}
