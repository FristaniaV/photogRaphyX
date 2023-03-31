package photogRaphyX;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PhotogRaphyX {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<Double> sizeList = new ArrayList<>();
	ArrayList<String> detailList = new ArrayList<>();
	ArrayList<String> IDList = new ArrayList<>();

	String name;
	double size;
	String detail;
	String ID;

	public PhotogRaphyX() {
		Menu();
	}

	public void Menu() {
		int choose = 0;

		do {
			System.out.println("PhotogRaphyX");
			System.out.println("============");
			System.out.println("1. View Photo(s)");
			System.out.println("2. Insert Photo");
			System.out.println("3. Delete Photo");
			System.out.println("4. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scan.nextLine();
			if (choose == 1) {
				View();
			} else if (choose == 2) {
				Insert();
			} else if (choose == 3) {
				Delete();
			} else if (choose == 4) {
				System.exit(0);
			}
		} while (choose > 4 || choose < 1);
	}
	
	public void View() {
		for (int i = 0; i < nameList.size(); i++) {
			for (int j = 0; j < nameList.size() - 1; j++) {
				if (IDList.get(j).compareTo(IDList.get(j + 1)) > 0) {
					String temp;
					double temporary;

					temporary = sizeList.get(j);
					sizeList.set(j, sizeList.get(j+1));
					sizeList.set((j+1), temporary);
					
					temp = nameList.get(j);
					nameList.set(j, nameList.get(j + 1));
					nameList.set((j + 1), temp);

					temp = detailList.get(j);
					detailList.set(j, detailList.get(j + 1));
					detailList.set((j + 1), temp);

					temp = IDList.get(j);
					IDList.set(j, IDList.get(j + 1));
					IDList.set((j + 1), temp);
				}
			}
		}
		
		if (nameList.isEmpty()) {
			System.out.println("Empty Photo List");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			Menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println((i + 1) + ". " + IDList.get(i) + " - " + nameList.get(i) + "(" + sizeList.get(i)
						+ ") | " + detailList.get(i));
			}
		}
		System.out.println();
		Menu();
	}

	public void Insert() {

		String id = "";

		do {
			System.out.print("Photo Name (Case Sensitive) [.jpg | .png | .jpeg]: ");
			name = scan.nextLine();
		} while (!(name.endsWith(".jpg")) && !(name.endsWith(".png")) && !(name.endsWith(".jpeg")));
		nameList.add(name);

		do {
			System.out.print("Photo Size (MB) [0.01 - 99.99]: ");
			size = scan.nextDouble();
			scan.nextLine();
		} while (size < 0.01 || size > 99.99);
		sizeList.add(size);

		do {
			System.out.print("Photo Detail (Case Sensitive) [ Public | Private ]: ");
			detail = scan.nextLine();
		} while (!(detail.equals("Public")) && !(detail.equals("Private")));
		detailList.add(detail);

		int randomNumber = rand.nextInt(10);
		int randomNumber2 = rand.nextInt(10);
		int randomNumber3 = rand.nextInt(10);
		int randomNumber4 = rand.nextInt(10);
		int randomNumber5 = rand.nextInt(10);
		id += "Photo";
		id += (randomNumber + "");
		id += (randomNumber2 + "");
		id += (randomNumber3 + "");
		id += (randomNumber4 + "");
		id += (randomNumber5 + "");
		System.out.println("Success Insert Photo with ID " + id);
		IDList.add(id);
		System.out.println("Press Enter to Continue...");
		scan.nextLine();
		Menu();

	}

	public void Delete() {
		int index = 0;
		
		if (nameList.isEmpty()) {
			System.out.println("Empty Photo List");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			Menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println((i + 1) + ". " + IDList.get(i) + " - " + nameList.get(i) + "(" + sizeList.get(i)
						+ ") | " + detailList.get(i));
			}
			do {
				System.out.print("Input Photo Index [1-" + nameList.size() + "]: ");
				index = scan.nextInt(); scan.nextLine();
			} while (index < 1 || index > nameList.size());
			
			nameList.remove(index-1);
			IDList.remove(index-1);
			sizeList.remove(index-1);
			detailList.remove(index-1);
			System.out.println("Success Delete Photo");
			
			System.out.println("Press Enter to Continue...");
			Menu();
		}
	}

	public static void main(String[] args) {
		new PhotogRaphyX();

	}

}
