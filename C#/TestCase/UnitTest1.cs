using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Users;
using Projects;
using Expenses;


namespace TestCase
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            User user = new User("John Doe", User.TaxStatus.SINGLE, false);
            user.AddProject("website", 200_000, "");
            user.AddExpense("", Expense.ExpenseCategory.ADVERTISING, 0, 44_291, "");
            Assert.AreEqual(39_814, user.GetPredictedTax());
        }

        [TestMethod]
        public void TestMethod2()
        {
            User user = new User("John Doe", User.TaxStatus.SINGLE, false);
            Assert.AreEqual(0, user.GetPredictedTax());
        }
    }
}
