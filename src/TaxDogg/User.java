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
	
}
