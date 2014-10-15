using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class Delete
    {
        public static void DeleteUsers()
        {
            Presentation.DeletePresentation();
            ShowUser.ShowUsers();

            Console.WriteLine("");
            Console.Write("Vilken användare vill du ta bort?: ");
            int deleteChoice = int.Parse(Console.ReadLine());

            string deleteMemberQuery = "CALL `deleteMember`" + "(" + deleteChoice + ");";
            SQLconnection.DeleteBoatSQL(deleteMemberQuery);

            Console.Clear();
            Presentation.UserIsDeleted();
            Program.ContinueOnKeyPressed();
        }
    }
}