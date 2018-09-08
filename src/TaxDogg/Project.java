package TaxDogg;

public class Project {

String name;
double grossIncome;
String description;

	public Project(String name, double income, String description) 
	{
		this.name = name;
		this.grossIncome = income;
		this.description = description;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public double getIncome()
	{
		return grossIncome;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setName(String newName) 
	{
		this.name = newName;
	}
	
	public void setIncome(double newIncome) 
	{
		this.grossIncome = newIncome;
	}
	
	public void setDescripion(String newDescription) 
	{
		this.description = newDescription;
	}
	
}
