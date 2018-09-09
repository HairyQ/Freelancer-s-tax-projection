using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Expenses
{
    /// <summary>
    /// Way to store a single expense. Gives get methods for all variables
    /// belonging to an expense.No set or changing methods because could
    /// cause too many problems.If user wishes to change something about
    /// an expense, will need to simply delete and create a new expense.
    /// </summary>
    public class Expense
    {

        // User Inputs
        private readonly String name;
        private readonly ExpenseCategory category;
        private readonly double cost;
        private readonly String description;
        private readonly int mileage;

        // Calculations
        private double expenseDeductible;
        
        // Date
        private readonly DateTime dateAdded;
        
        // Enum ExpenseCategories
        public enum ExpenseCategory
        {
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
        };

        
        /// <summary>
        /// Basic constructor for a single expense. Need all parameters in order
        /// to store the information.
        /// </summary>
        /// <param name="name">name of expense</param>
        /// <param name="category">expense category</param>
        /// <param name="mileage">mileage (if any)</param>
        /// <param name="cost">cost of expense</param>
        /// <param name="description">optional description (will be "" if none)</param>
        public Expense(String name, ExpenseCategory category, int mileage, 
                        double cost, String description)
        {
            this.name = name;
            this.category = category;
            this.mileage = mileage;
            this.cost = cost;
            this.description = description;
            this.expenseDeductible = 0;
            FindExpenseDeductible(); // will adjust expenseDeductible
            this.dateAdded = DateTime.Today;
        }
        
        /// <summary>
        /// Looks at the category and will give the correct amount that
        /// is actually deductible for the given expense information.
        /// </summary>
        private void FindExpenseDeductible()
        {
            switch (this.category)
            {
                case ExpenseCategory.BUSINESS_MEALS:
                    this.expenseDeductible = cost / 2;
                    break;
                case ExpenseCategory.DRIVE_MILEAGE:
                    this.expenseDeductible = mileage * 0.545;
                    break;
                default:
                    this.expenseDeductible = cost;
                    break;
            }
        }
        
        /// <returns>name of expense</returns>
        public String GetName()
        {
            return this.name;
        }
        
        /// <returns>expense category</returns>
        public ExpenseCategory GetCategory()
        {
            return category;
        }
        
        /// <returns>cost of expense</returns>
        public double GetCost()
        {
            return this.cost;
        }

        /// <returns>description of expense</returns>
        public String GetDescription()
        {
            return this.description;
        }

        /// <returns>expense deductible based on inputed information</returns>
        public double GetExpenseDeductible()
        {
            return this.expenseDeductible;
        }

        /// <returns>date expense was added</returns>
        public DateTime GetDate()
        {
            return this.dateAdded;
        }
    }

}
