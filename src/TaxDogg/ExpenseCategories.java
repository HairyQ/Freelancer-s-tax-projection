package TaxDogg;

/**
 * Valid Expense Categories. Will be used in Expense Class
 * for categorizing different types of expenses.
 * 
 * @author Last Place
 */
public enum ExpenseCategories {
	/*
	 * All can fall into same case where we will need to enter
	 * cost, name. These have no extra parameters to the deductible
	 * cost.
	 */
	ADVERTISING,
	BUSINESS_LICENSE,
	CONTRACT_LABOR,
	LEGAL_AND_PROFESSIONAL_FEES,
	OFFICE_EXPENSES,
	RENT_EXPENSE,
	REPAIRS_AND_MAITENANCE,
	SUPPLIES,
	TELECOMMUNICATIONS,
	TRAVEL,
	
	/* 
	 * Only 50% goes toward deductible cost.
	 */
	BUSINESS_MEALS,
	/*
	 * Will need extra mileage parameter to calculate total
	 * amount to be deducted. 54.5 cents * mileage.
	 */
	DRIVE_MILEAGE
}
