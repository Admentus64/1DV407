using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class AddUser
    {
        public static void addUser()
        {
            string fname;
            string lname;
            int pNumber;

            Presentation.Adduser();

            Console.Write("Skriv in förnamn: ");
            fname = Console.ReadLine();

            Console.Write("Skriv in efternamn: ");
            lname = Console.ReadLine();

            do
            {
                Console.Write("Skriv in personnummer: ");
            } while (!int.TryParse(Console.ReadLine(), out pNumber) || pNumber < 0);


            string addUserQuery = "INSERT INTO member (firstname, lastname, socialsecuritynumber) VALUES ( " + "'" + fname + "'" + "," + "'" + lname + "'" + "," + "'" + pNumber + "'" + ")";
            SQLconnection.con(addUserQuery);

            Console.Clear();
            Presentation.UserIsAdded();
            Program.ContinueOnKeyPressed();
            Program.Menu();
        }
    }
}
