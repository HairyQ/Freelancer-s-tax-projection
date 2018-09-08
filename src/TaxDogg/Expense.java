package TaxDogg;

public class Expense {

	private String name;
	private ExpenseCategory category;
	private double cost;
	private String description;
	
	public Expense(String name, ExpenseCategory category, double cost, String description)
	{
		this.name = name;
		this.category = category;
		this.cost = cost;
		this.description = description;
	}	
}
