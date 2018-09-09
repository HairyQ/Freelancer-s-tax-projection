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
		this.netIncome = getGrossIncome();
		this.predictedTax = getPredictedTax(getTaxableIncome());
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
	
	public double getGrossIncome()
	{
		double income = 0;
		for (Project proj : projects)
		{
			income += proj.getIncome();
		}
		return income;
	}
	
	public double getFinalExpenses()
	{
		double cost = 0;
		for (Expense exp : expenses)
		{
			cost += exp.getExpenseDeductible();
		}
		return cost;
	}
	
	public int getStandardDeduction()
	{
		if (taxStatus == TaxStatus.MARRIED_JOINT)
			return 24000;
		else if (taxStatus == TaxStatus.HEAD_OF_HOUSEHOLD)
			return 18000;
		else
			return 12000;
	}
	
	public double getSelfEmploymentTax()
	{
		double incomeFromBiz = getGrossIncome() * 0.9235;
		double medicare = incomeFromBiz * 0.029;
		
		if (incomeFromBiz <= 128400)
			return (incomeFromBiz * 0.153) / 2;
		else
			return (medicare + (128400 * 0.124)) / 2;
	}
	
	public double getTaxableIncome()
	{
		double taxOwed = 0;
		double adjustments = getSelfEmploymentTax() + 1200;
		return getGrossIncome() - getStandardDeduction();
	}
	
	public double getPredictedTax(double taxableIncome)
	{
		if (taxStatus == TaxStatus.SINGLE) {
			if (taxableIncome <= 9525)
				return 0.1 * taxableIncome;
			if ((9525 < taxableIncome)  && (taxableIncome <= 38700))
				return ((taxableIncome-9525) * 0.12) + 952.5;
			if ((38700 < taxableIncome) && (taxableIncome <= 82500))
				return ((taxableIncome-38700) * 0.22) + 4453.5;
			if ((82500 < taxableIncome) && (taxableIncome <= 157500))
				return ((taxableIncome-82500) * 0.24) + 14089.5;
			if ((157500 < taxableIncome) && (taxableIncome <= 200000))
				return ((taxableIncome-157500) * 0.32) + 32089.5;
			if ((200000 < taxableIncome) && (taxableIncome <= 500000))
				return ((taxableIncome-200000) * 0.35) + 45689.5;
			if (taxableIncome > 500000)
				return ((taxableIncome-500000) * 0.37) + 150689.5;
		}
		else if (taxStatus == TaxStatus.HEAD_OF_HOUSEHOLD) {
			if (taxableIncome <= 13600)
				return 0.1 * taxableIncome;
			if ((13600 < taxableIncome) && (taxableIncome <= 51800))
				return ((taxableIncome-13600) * 0.12) + 1360;
			if ((51800 < taxableIncome) && (taxableIncome <= 82500))
				return ((taxableIncome-51800) * 0.22) + 5944;
			if ((82500 < taxableIncome) && (taxableIncome <= 157500)) 
				return ((taxableIncome-82500) * 0.24) + 12698;
			if ((157500 < taxableIncome) && (taxableIncome <= 200000))
				return ((taxableIncome-157500) * 0.32) + 30698;
			if ((200000 < taxableIncome) && (taxableIncome <= 500000)) 
				return ((taxableIncome-200000) * 0.35) + 44298;
			if (taxableIncome > 500000)
				return ((taxableIncome-500000) * 0.37) + 149298;
		}
		else if (taxStatus == TaxStatus.MARRIED_SEPERATE) {
			if (taxableIncome <= 9525)
				return 0.1 * taxableIncome;
			if ((9525 < taxableIncome) && (taxableIncome <= 38700))
				return ((taxableIncome-9525) * 0.12) + 952.50;
			if ((38700 < taxableIncome) && (taxableIncome <= 82500))
				return ((taxableIncome-38700) * 0.22) + 4453.50;
			if ((82500 < taxableIncome) && (taxableIncome <= 157500))
				return ((taxableIncome-82500) * 0.24) + 14089.50;
			if ((157500 < taxableIncome) && (taxableIncome <= 200000))
				return ((taxableIncome-157500) * 0.32) + 32089.50;
			if ((200000 < taxableIncome) && (taxableIncome <= 300000))
				return ((taxableIncome-200000) * 0.35) + 45689.50;
			if (300000 < taxableIncome)
				return ((taxableIncome-300000) * 0.37) + 80689.50;
		}
		else if (taxStatus == TaxStatus.MARRIED_JOINT) {
			if (taxableIncome <= 19050)
				return 0.1 * taxableIncome;
			if ((19050 < taxableIncome) && (taxableIncome <= 77400))
				return ((taxableIncome-19050) * 0.12) + 1905;
			if ((77400 < taxableIncome) && (taxableIncome <= 165000))
				return ((taxableIncome-77400) * 0.22) + 8907;
			if ((165000 < taxableIncome) && (taxableIncome <= 315000))
				return ((taxableIncome-16500) * 0.24) + 28179;
			if ((315000 < taxableIncome) && (taxableIncome <= 400000))
				return ((taxableIncome-400000) * 0.32) + 64179;
			if ((400000 < taxableIncome) && (taxableIncome <= 600000))
				return ((taxableIncome-400000) * 0.35) + 91379;
			if (taxableIncome < 600000) 
				return ((taxableIncome-600000) * 0.37) + 161379;
		}
		return 0;
	}
}
