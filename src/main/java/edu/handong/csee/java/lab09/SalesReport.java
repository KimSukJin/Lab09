package edu.handong.csee.java.lab09;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class gets some information of salesmen and print out who is the best seller.
 * @author KimSukJin
 * @since 180414
 */
public class SalesReport {

	private double highestSales; //instantiates variables
	private double averageSales; //instantiates variables
	ArrayList<String> members = new ArrayList<String>(); //instantiates ArrayList
	static ArrayList<Double> amountOfSales = new ArrayList<Double>(); //instantiates ArrayList

	public static void main(String[] args) {

		SalesReport myReporter = new SalesReport(); 
		myReporter.run();
		myReporter.printOutResults();
	}
/**
 * This method gets information from user and calculate average sales and the highest sales 
 * 
 */
	public void run() {
		System.out.println("Enter some information of salesmen");

		Scanner myScanner = new Scanner(System.in); 

		boolean done = false;
		
		while (!done) {
			System.out.println("Enter name: ");
			String name = myScanner.nextLine(); 

			System.out.println("Enter sales: ");
			double sales = myScanner.nextDouble();

			members.add(name); //substitutes name into ArrayList
			amountOfSales.add(sales); //substitutes sales into ArrayList

			System.out.println("More members for the list? (Enter \"yes\" if you want)");
			
			myScanner.nextLine();
			String ans = myScanner.nextLine();
			
			if (!ans.equalsIgnoreCase("yes"))
				done = true; //User enter 'yes', then quit
		}

		int listsize = amountOfSales.size();
		double sum = 0;
		for (int index = 0; index < listsize; index++) {
			sum = sum + amountOfSales.get(index);
		} //adds every value in ArrayList
		averageSales = sum / listsize; //calculates average

		listsize = amountOfSales.size();
		if (listsize == 1)
			highestSales = amountOfSales.get(0); //If ArrayList has one index, that value is the highest
		else {
			for (int index = 0; index < listsize - 1 ; index++) {
				highestSales = amountOfSales.get(0);
				if(highestSales < amountOfSales.get(index + 1))
					highestSales = amountOfSales.get(index + 1);
							}// calculates value that is the highest
		}
		myScanner.close();
	}
/**
 * This method prints out results that shows average of ArrayList and man who is the best seller.
 */
	public void printOutResults() {

		System.out.println("Average: " + averageSales); //prints out average
		System.out.println("Highest sales: " + highestSales); //prints out highest sales

		System.out.println("The Highest sales guy");

		int listsize = amountOfSales.size();
		for (int position = 0; position < listsize; position++) {
			if (amountOfSales.get(position) == highestSales) {
				System.out.println("Name: " + members.get(position));
				System.out.println("Sales: " + amountOfSales.get(position));
			} //prints out informaion of the best seller
		}
	}

}
