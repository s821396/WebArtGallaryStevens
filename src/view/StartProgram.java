package view;

import java.util.List;
import java.util.Scanner;

import controller.ArtworkHelper;
import model.Artwork;



public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ArtworkHelper awh = new ArtworkHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		System.out.print("Enter an artist name: ");
		String artistName = in.nextLine();
		System.out.print("Enter a media: ");
		String media = in.nextLine();
		System.out.print("Enter a year: ");
		String year = in.nextLine();
		System.out.print("Enter the value: ");
		double value = in.nextDouble();
		
				
		Artwork toAdd = new Artwork(title, artistName, media, year, value);
		awh.insertArtwork(toAdd);

	}
	
	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();
		Artwork toDelete = new Artwork(title);
		awh.deleteArt(toDelete);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
			
		}
		
	}
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Artwork> allItems = awh.showAllItems();
		for(Artwork aw: allItems) {
			System.out.println(aw.returnItemDetails());
		}
	}
}
	