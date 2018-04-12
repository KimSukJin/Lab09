package edu.handong.csee.java.lab09;

import java.util.Scanner;
/**
 * This class gets salesmen' informations and shows us guy who is the best seller.
 * 
 * @since 180412
 * @author KimSukJin
 *
 */
public class SalesReport {

	private double highestSales; //instantiating variables.
	private double averageSales; //instantiating variables.
	private Salesman[] team; //instantiating Array
	private int numOfSalesman; //instantiating variables.

	public SalesReport() {
		System.out.println("Enter number of Salesman:");
		Scanner myScanner = new Scanner(System.in);
		numOfSalesman = myScanner.nextInt();
	} // gets number from user and puts into variable 'numOfSalesman'

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalesReport myReporter = new SalesReport(); 
		myReporter.getData();
		myReporter.calculateAverageSales();
		myReporter.highestSales();
		myReporter.printOutResults();
	}

	public void getData() {
		team = new Salesman[numOfSalesman]; 

		for (int i = 0; i < numOfSalesman; i++) { //repeats until NumOfSalesman
			Scanner myScanner = new Scanner(System.in); 

			System.out.println("Enter name: ");
			String name = myScanner.nextLine(); // gets salesman's name
			
			System.out.println("Enter sales: ");
			double sales = myScanner.nextDouble(); //gets salesman's sales
			
			Salesman mySalesman = new Salesman();
			mySalesman.setmName(name);
			mySalesman.setSales(sales);
			team[i] = mySalesman; //inputs mySalesman into team array
		}
	}

	public void calculateAverageSales() {
		double sum = 0; //instantiating variables.

		for (int i = 0; i < team.length; i++) { //repeats until length of team
			double sales = team[i].getSales();
			sum = sum + sales; //adds all sales
		} 

		averageSales = sum / team.length; //gets average
	}

	public void highestSales() {
		for (int i = 0; i < team.length - 1; i++) {//reapeat until length of team - 1
			if (team[i].getSales() < team[i + 1].getSales()) { //if data in low index number is smaller than high index number 
				highestSales = team[i + 1].getSales(); // inputs sales that is highest into highestSales
			}
		}
	}

	public void printOutResults() {
		System.out.println("Average: " + averageSales);
		System.out.println("Highest sales: " + highestSales); //print out average and highest sales

		System.out.println("The Highest sales guy");
		for (int i = 0; i < team.length; i++) { //repeats until length of team
			if (team[i].getSales() == highestSales) { 
				System.out.println("Name: " + team[i].getmName());
				System.out.println("Sales: " + team[i].getSales());
			}
		} //print out information of guy who is the best seller
	}

}
