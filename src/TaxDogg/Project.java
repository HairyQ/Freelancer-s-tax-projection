package TaxDogg;

/**
 * @author Last Place
 * @author Harrison Quick
 *
 *The project class is used to store user-input information regarding a project they are working on so that 
 */
public class Project {

	private String name;
	private double grossIncome;
	private String description;

	/**
	 * Constructor that sets Project's name, income and description
	 * @param name The name of the project
	 * @param income The gross income the user will make from the project
	 * @param description A user-defined description of the project
	 */
	public Project(String name, double income, String description) 
	{
		this.name = name;
		this.grossIncome = income;
		this.description = description;
	}
	
	/**
	 * @return The name of the project
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @return The gross income from the project
	 */
	public double getIncome()
	{
		return grossIncome;
	}
	
	/**
	 * @return A description of the project
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/**
	 * @param newName New name for the project
	 */
	public void setName(String newName) 
	{
		this.name = newName;
	}
	
	/**
	 * @param newIncome Changed income of the project
	 */
	public void setIncome(double newIncome) 
	{
		this.grossIncome = newIncome;
	}
	
	/**
	 * @param newDescription Changed description of the project
	 */
	public void setDescripion(String newDescription) 
	{
		this.description = newDescription;
	}
	
}
