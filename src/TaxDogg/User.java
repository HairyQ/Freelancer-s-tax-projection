package TaxDogg;

import java.util.ArrayList;

public class User {

	private String name;
	private TaxStatus taxStatus;
	private boolean employed;
	private ArrayList<Project> projects;
	private ArrayList<Expense> expenses;
	private double netIncome;
	private double predictedTax;
	
	/**
	 * User class defines user information, also includes project and expense lists and information
	 * @param name User's name
	 * @param status User's marital status
	 * @param employed User's employment status - true if employed, false otherwise
	 */
	public User(String name, TaxStatus status, boolean employed)
	{
		this.name = name;
		this.taxStatus = status;
		this.employed = employed;
		this.projects = new ArrayList<Project>();
		this.expenses = new ArrayList<Expense>();
		this.netIncome = 0;
		this.predictedTax = 0;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public TaxStatus getTaxStatus() 
	{
		return this.taxStatus;
	}
	
	public boolean getEmployed()
	{
		return this.employed;
	}
	
	public double getTaxableIncome()
	{
		return 0;
	}
	
	public double getPredictedTax(double taxableIncome)
	{
		double x = taxableIncome;
		
		if (taxStatus == TaxStatus.SINGLE) {
			if (x <= 9525)
				return 0.1 * x;
			if ((9525 < x)  && (x <= 38700))
				return ((x-9525) * 0.12) + 952.5;
			if ((38700 < x) && (x <= 82500))
				return ((x-38700) * 0.22) + 4453.5;
			if ((82500 < x) && (x <= 157500))
				return ((x-82500) * 0.24) + 14089.5;
			if ((157500 < x) && (x <= 200000))
				return ((x-157500) * 0.32) + 32089.5;
			if ((200000 < x) && (x <= 500000))
				return ((x-200000) * 0.35) + 45689.5;
			if (x > 500000)
				return ((x-500000) * 0.37) + 150689.5;
		}
		else if (taxStatus == TaxStatus.HEAD_OF_HOUSEHOLD) {
			
		}
		else if (taxStatus == TaxStatus.MARRIED_SEPERATE) {
			
		}
		else if (taxStatus == TaxStatus.MARRIED_JOINT) {
			
		}
		return 0;
	}
	
}
