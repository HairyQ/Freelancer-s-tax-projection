using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projects
{
    public class Project
    {

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
        public String GetName()
        {
            return name;
        }

        /**
         * @return The gross income from the project
         */
        public double GetIncome()
        {
            return grossIncome;
        }

        /**
         * @return A description of the project
         */
        public String GetDescription()
        {
            return description;
        }

        /**
         * @param newName New name for the project
         */
        public void SetName(String newName)
        {
            this.name = newName;
        }

        /**
         * @param newIncome Changed income of the project
         */
        public void SetIncome(double newIncome)
        {
            this.grossIncome = newIncome;
        }

        /**
         * @param newDescription Changed description of the project
         */
        public void SetDescripion(String newDescription)
        {
            this.description = newDescription;
        }
    }
}
