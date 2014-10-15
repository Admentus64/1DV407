using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class EditUser
    {
        public static void EditUserInfo()
        {
            Presentation.EditUsers();
            ShowUser.ShowUsers();

            Console.WriteLine("");
            Console.Write("Välj vem du vill editera: ");
            string userEdit = Console.ReadLine();

            Console.Write("Skriv in ett nytt förnamn: ");
            string fName = Console.ReadLine();

            Console.Write("Skriv in ett nytt efternamn: ");
            string lName = Console.ReadLine();

            Console.Write("Skriv in ett nytt  personnummer: ");
            string pNumber = Console.ReadLine();

            string editUserQuery = "UPDATE member SET firstname='" + fName + "'" + ", lastname='" + lName + "'" + ", socialsecuritynumber= '" + pNumber + "'" + " WHERE memberID='" + userEdit + "'";

            SQLconnection.addBoatconn(editUserQuery);

            Console.Clear();
            Presentation.MemberIsEdit();
            Program.ContinueOnKeyPressed();
        }
    }
}
