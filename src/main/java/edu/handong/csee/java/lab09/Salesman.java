package edu.handong.csee.java.lab09;

/**
 * This class has some information about salesmen. Also it has 4 methods that
 * getting their names, sales and setting their names, sales.
 * 
 * @author KimSukJin
 * @since 180412
 *
 */
public class Salesman {
	private String mName; // instantiating String 'mName'
	private double sales; // instantiating variable 'sales'

	public String getmName() { // getting name
		return mName; // return name
	}

	public double getSales() { // getting sales
		return sales; // return sales
	}

	public void setmName(String mName) { // setting name
		this.mName = mName; // inputs value of mName into class variable
	}

	public void setSales(double sales) { // setting sales
		this.sales = sales; // inputs value of sales into class variable
	}

}