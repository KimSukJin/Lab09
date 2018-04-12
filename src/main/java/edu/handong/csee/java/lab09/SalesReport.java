package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReport {

	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numOfSalesman;

	public SalesReport() {
		System.out.println("Enter number of Salesman:");
		Scanner myScanner = new Scanner(System.in);
		numOfSalesman = myScanner.nextInt();
	}

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

		for (int i = 0; i < numOfSalesman; i++) {
			Scanner myScanner = new Scanner(System.in);
			System.out.println("Enter data for associate number " + (i + 1));

			System.out.println("Enter name: ");
			String name = myScanner.nextLine();
			
			System.out.println("Enter sales: ");
			double sales = myScanner.nextDouble();
			
			Salesman mySalesman = new Salesman();
			mySalesman.setmName(name);
			mySalesman.setSales(sales);
			team[i] = mySalesman;
		}
	}

	public void calculateAverageSales() {
		double sum = 0;

		for (int i = 0; i < team.length; i++) {
			double sales = team[i].getSales();
			sum = sum + sales;
		}

		averageSales = sum / team.length;
	}

	public void highestSales() {
		for (int i = 0; i < team.length - 1; i++) {
			if (team[i].getSales() < team[i + 1].getSales()) {
				highestSales = team[i + 1].getSales();
			}
		}
	}

	public void printOutResults() {
		System.out.println("Average: " + averageSales);
		System.out.println("Highest sales: " + highestSales);

		System.out.println("The Highest sales guy");
		for (int i = 0; i < team.length; i++) {
			if (team[i].getSales() == highestSales) {
				System.out.println("Name: " + team[i].getmName());
				System.out.println("Sales: " + team[i].getSales());
			}
		}
	}

}
