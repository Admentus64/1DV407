using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class EditBoat
    {
        public static void EditBoats()
        {
            ShowUser.ShowUsers();

            Console.WriteLine("");
            Console.Write("Vilken medlem vill du ändra en båt hos: ");
            int userChoice = int.Parse(Console.ReadLine());

            string showBoatQuery = "CALL `displayBoat`" + "(" + userChoice + ");";
            SQLconnection.DeleteBoatSQL(showBoatQuery);

            Console.WriteLine("Vilken båt vill ändra..?");
            int userBoatChoice = int.Parse(Console.ReadLine());

            Console.WriteLine("Ange nya båtvärden..");

            Console.WriteLine("Ny båtlängd:");
            string newBoatLength = Console.ReadLine();

            Console.WriteLine("Ange en ny båttyp:");
            Console.WriteLine("1.Segelbåt 2.Motorseglare 3.Motorbåt 4.Kajak/Kanot 5.Övrigt");
            string newBoatype = Console.ReadLine();

            string editBoatQuery = "UPDATE boat SET boattypeID='" + newBoatype + "'" + ", boatlength='" + newBoatLength + "'" + " WHERE boatID='" + userBoatChoice + "'";

            SQLconnection.con(editBoatQuery);

            Console.Clear();
            Presentation.BoatIsEdited();
            Program.ContinueOnKeyPressed();
        }
    }
}
