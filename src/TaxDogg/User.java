package TaxDogg;

public class User {

	private String name;
	private TaxStatus taxStatus;
	private boolean employed;
	
	/**
	 * User class defines user information, also includes project and expense lists and information
	 * @param name User's name
	 * @param status User's marital status
	 * @param employed User's employement status - true if employed, false otherwise
	 */
	public User(String name, TaxStatus status, boolean employed)
	{
		this.name = name;
		this.taxStatus = status;
		this.employed = employed;
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
