package TaxDogg;

import java.time.LocalDate;

/**
 * Way to store a single expense. Gives get methods for all variables
 * belonging to an expense. No set or changing methods because could
 * cause too many problems. If user wishes to change something about 
 * an expense, will need to simply delete and create a new expense.
 * 
 * @author Last Place
 * @author Kris Wollf
 */
public class Expense {
	
	// User Inputs
	private String name;
	private ExpenseCategory category;
	private double cost;
	private String description;
	private int mileage;
	
	// Calculations
	private double expenseDeductible;
	// Date
	private LocalDate dateAdded;
	
	/**
	 * Basic constructor for a single expense. Need all parameters in order
	 * to store the information.
	 * @param name
	 * @param category
	 * @param mileage
	 * @param cost
	 * @param description
	 */
	public Expense(String name, ExpenseCategory category, int mileage, 
					double cost, String description)
	{
		this.name = name;
		this.category = category;
		this.mileage = mileage;
		this.cost = cost;
		this.description = description;
		this.expenseDeductible = 0;
		findExpenseDeductible(); // will adjust expenseDeductible
		this.dateAdded = java.time.LocalDate.now();
	}	
	
	/**
	 * Looks at the category and will give the correct amount that
	 * is actually deductible for the given expense information.
	 */
	private void findExpenseDeductible()
	{
		switch (this.category) {
			case BUSINESS_MEALS:
				this.expenseDeductible = cost / 2;
				break;
			case DRIVE_MILEAGE:
				this.expenseDeductible = mileage * 0.545;
			default:
				this.expenseDeductible = cost;
				break;
		}
	}
	
	/*** GET METHODS ***/
	
	/**
	 * @return name of expense
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * @return category of expense
	 */
	public ExpenseCategory getCategory()
	{
		return this.category;
	}
	
	/**
	 * @return cost of expense
	 */
	public double getCost()
	{
		return this.cost;
	}
	
	/**
	 * @return description of expense
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * @return expense deductible based on inputed information
	 */
	public double getExpenseDeductible()
	{
		return this.expenseDeductible;
	}
	
	/**
	 * @return date expense was added
	 */
	public LocalDate getDate()
	{
		return this.dateAdded;
	}
}
