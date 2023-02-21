package com.zsgs.librarymanagement.setuplibrary;

import java.util.Scanner;

import com.zsgs.librarymanagement.dto.Library;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebooks.ManageBooksView;

public class SetupLibraryView implements SetupLibraryViewCallBack {

	private Scanner scanner = new Scanner(System.in);
	private SetupLibraryControllerCallBack setupLibraryController;

	public SetupLibraryView() {
		this.setupLibraryController = new SetupLibraryController(this);
	}

	public void create() {
		setupLibraryController.onCreate();
	}

	@Override
	public void onLibraryExists(Library library) {
		System.out.flush();
		System.out.println("Welcome to the " + library.getName()+" Library");
		System.out.println("Here is the library details.");
		showLibraryDetails(library);
		System.out.println("\nif you need to update the library details please follow the instructions.");
		showUpdateOptions(library);
	}

	private void showUpdateOptions(Library library) {
		while (true) {
			System.out.println("\n1. Update Name");
			System.out.println("2. Update Address");
			System.out.println("3. Phone Number");
			System.out.println("4. Book Capacity");
			System.out.println("5. Seat Capacity");
			System.out.println("6. View Library Details");
			System.out.println("7. Proceed to Manage books");
			System.out.println("8. Logout");
			System.out.print("Select the option do you want to update:");
			int choice = 0;
			if(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("");
			} 
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Current Name - " + library.getName() + "\n");
				System.out.print("Enter new Name - ");
				String name = scanner.next();
				library.setName(name);
				setupLibraryController.updateLibraryDetails(library);
				System.out.print("\nUpdated Sucessfully.\n----------------------------\n ");
				break;
			}
			case 2: {
				System.out.println("Current Address - " + library.getAddress() + "\n");
				System.out.print("Enter new Address - ");
				String address = scanner.next();
				library.setAddress(address);
				setupLibraryController.updateLibraryDetails(library);
				System.out.print("\nUpdated Sucessfully.\n----------------------------\n ");
				break;
			}
			case 3: {
				System.out.println("Current PhoneNumber - " + library.getPhoneNumber() + "\n");
				System.out.print("Enter new PhoneNumber - ");
				String phoneNumber = scanner.next();
				library.setPhoneNumber(phoneNumber);
				setupLibraryController.updateLibraryDetails(library);
				System.out.print("\nUpdated Sucessfully.\n----------------------------\n ");
				break;
			}
			case 4: {
				System.out.println("Current Book Capacity - " + library.getBooksCapacity() + "\n");
				System.out.print("Enter new Book Capacity - ");
				long capacity = scanner.nextLong();
				library.setBooksCapacity(capacity);
				setupLibraryController.updateLibraryDetails(library);
				System.out.print("\nUpdated Sucessfully.\n----------------------------\n ");
				break;
			}
			case 5: {
				System.out.println("Current Seat Capacity - " + library.getSeatingCapacity() + "\n");
				System.out.print("Enter new Seat Capacity - ");
				int capacity = scanner.nextInt();
				library.setSeatingCapacity(capacity);
				setupLibraryController.updateLibraryDetails(library);
				System.out.print("\nUpdated Sucessfully.\n----------------------------\n ");
				break;
			}
			case 6: {
				System.out.println("\nHere is the library details.\n----------------------------");
				showLibraryDetails(library);
				System.out.println("----------------------------");
				break;
			}
			case 7: {
				System.out.flush();
				System.out.println("\nProceeding to Manage Books\n");
				ManageBooksView loginView = new ManageBooksView();
				loginView.create();
				return;
			}
			case 8: {
				System.out.println("Are you sure, Do you want to logout? \n press y to logout");
				if (scanner.next().equals("y")) {
					System.out.flush();
					System.out.println("You have logged out successfully..");
					LoginView loginView = new LoginView();
					loginView.create();
					return;
				}
				System.out.println("Enter valid choice.");
				break;
			}
			default: {
				System.out.println("Enter valid choice.");
				break;
			}
			}
		}
	}

	@Override
	public void libraryAddedSuccessfully(Library library) {

	}

	@Override
	public void setupNewLibrary() {
		System.out.println("New Library has to be setuped. \nPlease provide the follwing details");
		Library library = new Library();

		System.out.print("Enter Library Name - ");
		String name = scanner.nextLine();
		library.setName(name);

		System.out.print("Enter new Address - ");
		String address = scanner.nextLine();
		library.setAddress(address);

		System.out.print("Enter PhoneNumber - ");
		String phoneNumber = scanner.nextLine();
		library.setPhoneNumber(phoneNumber);

		System.out.print("Enter Book Capacity - ");
		long capacity = scanner.nextLong();
		library.setBooksCapacity(capacity);

		System.out.print("Enter Seat Capacity - ");
		int seatCapacity = scanner.nextInt();
		library.setSeatingCapacity(seatCapacity);

		setupLibraryController.addNewLibrary(library);
	}

	private void showLibraryDetails(Library library) {
		System.out.println("Name - " + library.getName());
		System.out.println("Address - " + library.getAddress());
		System.out.println("Phone No - " + library.getPhoneNumber());
		System.out.println("Book Capacity - " + library.getBooksCapacity());
		System.out.println("Seating Capacity - " + library.getSeatingCapacity());
	}

	@Override
	public void onLibraryCreated(Library library) {
		System.out.flush();
		System.out.println("----------------------------\nLibrary setuped successfully.\n----------------------------");
		System.out.println("\nif you need to update the library details please follow the instructions.");
		showUpdateOptions(library);
	}

}
