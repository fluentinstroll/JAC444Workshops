package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FindStates {
	Map<String, Integer> Countries;
	Map<Integer, String> Capitals;
	Scanner input;
	boolean found = false;

	public FindStates() {
		Countries = new HashMap<String, Integer>();
		Countries.put("CANADA", 10);
		Countries.put("USA", 20);
		Countries.put("MEXICO", 30);
		Countries.put("CHINA", 40);
		Countries.put("INDIA", 50);
		Countries.put("JAPAN", 60);
		Countries.put("UNITED KINGDOM", 70);
		Countries.put("SOUTH KOREA", 80);
		Countries.put("ITALY", 90);
		Countries.put("GREECE", 100);
		Countries.put("GERMANY", 110);
		Countries.put("POLAND", 120);
		Countries.put("NORWAY", 130);
		Countries.put("BRAZIL", 140);
		Countries.put("AUSTRALIA", 150);
		Countries.put("RUSSIA", 160);
		Countries.put("FRANCE", 170);
		Countries.put("SOUTH AFRICA", 180);
		Countries.put("SPAIN", 190);
		Countries.put("COLOMBIA", 200);
		Countries.put("SAUDI ARABIA", 210);
		Countries.put("YEMEN", 220);
		Countries.put("VENEZUELA", 230);
		Countries.put("ROMANIA", 240);
		Countries.put("SYRIA", 250);

		Capitals.put(10, "Ottawa");
		Capitals.put(20, "Washington, D.C.");
		Capitals.put(30, "Mexico City");
		Capitals.put(40, "Beijing");
		Capitals.put(50, "New Delhi");
		Capitals.put(60, "Tokyo");
		Capitals.put(70, "London");
		Capitals.put(80, "Seoul");
		Capitals.put(90, "Rome");
		Capitals.put(100, "Athens");
		Capitals.put(110, "Berlin");
		Capitals.put(120, "Warsaw");
		Capitals.put(130, "Oslo");
		Capitals.put(140, "Brasilia");
		Capitals.put(150, "Canberra");
		Capitals.put(160, "Moscow");
		Capitals.put(170, "Paris");
		Capitals.put(180, "Cape Town");
		Capitals.put(190, "Madrid");
		Capitals.put(200, "Bogota");
		Capitals.put(210, "Riyadh");
		Capitals.put(220, "Sana'a");
		Capitals.put(230, "Caracas");
		Capitals.put(240, "Bucharest");
		Capitals.put(250, "Damascus");
		input = new Scanner(System.in);

	}

	public void displayCountries() {
		Set<Entry<String, Integer>> st = Countries.entrySet();
		for (Entry<String, Integer> me : st)
			System.out.println(me.getKey());
	}

	public String getCapital(String rec) {
		String newRec = rec.toUpperCase();
		if (Countries.containsKey(newRec)) {
			return Capitals.get(Countries.get(newRec));
		} else
			return "/n";
	}

	public void search() {
		String inputCountry = "/n";
		String capital;
		this.displayCountries();
		System.out.println("These are all the countries in this program!");
		while (!found) {
			try {
				System.out.print("Please enter the name of a country to see the capital: ");
				inputCountry = input.nextLine();
			} catch (Exception e) {
				System.out.println(e + "Please enter a country.");
				input.next();
			}

			capital = this.getCapital(inputCountry);

			if (capital == "/n")
				System.out.println("Please enter a country listed above to see the capital.");
			else
				System.out.println("The capital of " + inputCountry + " is " + capital);
			boolean chosen = false;
			while (!chosen) {
				String choice = "N";
				try {
					System.out.println("Search for another capital? (y/n): ");
					choice = input.nextLine();
				} catch (Exception e) {
					System.out.println("Please enter a selection (y/n");
				}
				if (choice.equals("y") || choice.equals("Y")) {
					chosen = true;
					found = false;
				} else if (choice.equals("n") || choice.equals("N")) {
					chosen = true;
					found = true;
				} else {
					System.out.println("Please enter a selection (y/n).");
				}
			}
		}
	}
}
