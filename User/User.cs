using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Expenses;
using Projects;

namespace Users
{
    public class User
    {
        public enum TaxStatus
        {
            SINGLE,
            MARRIED_SEPERATE,
            MARRIED_JOINT,
            HEAD_OF_HOUSEHOLD
        };

        private String name;
        private TaxStatus taxStatus;
        private bool employed;
        private List<Project> projects;
        private List<Expense> expenses;
        private double netIncome;
        private double predictedTax;

        public User(String name, TaxStatus status, bool employed)
        {
            this.name = name;
            this.taxStatus = status;
            this.employed = employed;
            this.projects = new List<Project>();
            this.expenses = new List<Expense>();
            this.netIncome = getGrossIncome();
            this.predictedTax = GetPredictedTax();
        }

        public void AddExpense(String name, Expense.ExpenseCategory category, 
                        int mileage, double cost, String description)
        {
            expenses.Add(new Expense(name, category, mileage, cost, description));
        }

        public void AddProject(String name, double income, String description)
        {
            projects.Add(new Project(name, income, description));
        }

        public String getName()
        {
            return this.name;
        }

        public TaxStatus getTaxStatus()
        {
            return this.taxStatus;
        }

        public bool getEmployed()
        {
            return this.employed;
        }

        public double getGrossIncome()
        {
            double income = 0;
            foreach (Project proj in projects)
            {
                income += proj.GetIncome();
            }
            return income;
        }

        public double getFinalExpenses()
        {
            double cost = 0;
            foreach (Expense exp in expenses)
            {
                cost += exp.GetExpenseDeductible();
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
            double adjustments = getSelfEmploymentTax() + 1200;
            return getGrossIncome() - getStandardDeduction();
        }

        public double GetPredictedTax()
        {
            if ((projects.Count() == 0) && (expenses.Count() == 0))
            {
                return 0;
            }
            if (taxStatus == TaxStatus.SINGLE)
            {
                if (getTaxableIncome() <= 9525)
                    return 0.1 * getTaxableIncome();
                if ((9525 < getTaxableIncome()) && (getTaxableIncome() <= 38700))
                    return ((getTaxableIncome() - 9525) * 0.12) + 952.5;
                if ((38700 < getTaxableIncome()) && (getTaxableIncome() <= 82500))
                    return ((getTaxableIncome() - 38700) * 0.22) + 4453.5;
                if ((82500 < getTaxableIncome()) && (getTaxableIncome() <= 157500))
                    return ((getTaxableIncome() - 82500) * 0.24) + 14089.5;
                if ((157500 < getTaxableIncome()) && (getTaxableIncome() <= 200000))
                    return ((getTaxableIncome() - 157500) * 0.32) + 32089.5;
                if ((200000 < getTaxableIncome()) && (getTaxableIncome() <= 500000))
                    return ((getTaxableIncome() - 200000) * 0.35) + 45689.5;
                if (getTaxableIncome() > 500000)
                    return ((getTaxableIncome() - 500000) * 0.37) + 150689.5;
            }
            else if (taxStatus == TaxStatus.HEAD_OF_HOUSEHOLD)
            {
                if (getTaxableIncome() <= 13600)
                    return 0.1 * getTaxableIncome();
                if ((13600 < getTaxableIncome()) && (getTaxableIncome() <= 51800))
                    return ((getTaxableIncome() - 13600) * 0.12) + 1360;
                if ((51800 < getTaxableIncome()) && (getTaxableIncome() <= 82500))
                    return ((getTaxableIncome() - 51800) * 0.22) + 5944;
                if ((82500 < getTaxableIncome()) && (getTaxableIncome() <= 157500))
                    return ((getTaxableIncome() - 82500) * 0.24) + 12698;
                if ((157500 < getTaxableIncome()) && (getTaxableIncome() <= 200000))
                    return ((getTaxableIncome() - 157500) * 0.32) + 30698;
                if ((200000 < getTaxableIncome()) && (getTaxableIncome() <= 500000))
                    return ((getTaxableIncome() - 200000) * 0.35) + 44298;
                if (getTaxableIncome() > 500000)
                    return ((getTaxableIncome() - 500000) * 0.37) + 149298;
            }
            else if (taxStatus == TaxStatus.MARRIED_SEPERATE)
            {
                if (getTaxableIncome() <= 9525)
                    return 0.1 * getTaxableIncome();
                if ((9525 < getTaxableIncome()) && (getTaxableIncome() <= 38700))
                    return ((getTaxableIncome() - 9525) * 0.12) + 952.50;
                if ((38700 < getTaxableIncome()) && (getTaxableIncome() <= 82500))
                    return ((getTaxableIncome() - 38700) * 0.22) + 4453.50;
                if ((82500 < getTaxableIncome()) && (getTaxableIncome() <= 157500))
                    return ((getTaxableIncome() - 82500) * 0.24) + 14089.50;
                if ((157500 < getTaxableIncome()) && (getTaxableIncome() <= 200000))
                    return ((getTaxableIncome() - 157500) * 0.32) + 32089.50;
                if ((200000 < getTaxableIncome()) && (getTaxableIncome() <= 300000))
                    return ((getTaxableIncome() - 200000) * 0.35) + 45689.50;
                if (300000 < getTaxableIncome())
                    return ((getTaxableIncome() - 300000) * 0.37) + 80689.50;
            }
            else if (taxStatus == TaxStatus.MARRIED_JOINT)
            {
                if (getTaxableIncome() <= 19050)
                    return 0.1 * getTaxableIncome();
                if ((19050 < getTaxableIncome()) && (getTaxableIncome() <= 77400))
                    return ((getTaxableIncome() - 19050) * 0.12) + 1905;
                if ((77400 < getTaxableIncome()) && (getTaxableIncome() <= 165000))
                    return ((getTaxableIncome() - 77400) * 0.22) + 8907;
                if ((165000 < getTaxableIncome()) && (getTaxableIncome() <= 315000))
                    return ((getTaxableIncome() - 16500) * 0.24) + 28179;
                if ((315000 < getTaxableIncome()) && (getTaxableIncome() <= 400000))
                    return ((getTaxableIncome() - 400000) * 0.32) + 64179;
                if ((400000 < getTaxableIncome()) && (getTaxableIncome() <= 600000))
                    return ((getTaxableIncome() - 400000) * 0.35) + 91379;
                if (getTaxableIncome() < 600000)
                    return ((getTaxableIncome() - 600000) * 0.37) + 161379;
            }
            return 0;
        }
    }
}
