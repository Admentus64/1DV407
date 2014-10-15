using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class DeleteBoat
    {
        public static void DeleteBoats()
        {
            ShowUser.ShowUsers();

            Console.WriteLine("Vilken medlem vill du ta bort en båt hos..?");
            int userChoice = int.Parse(Console.ReadLine());

            string showBoatQuery = "CALL `displayBoat`" + "(" + userChoice + ");";

            SQLconnection.DeleteBoatSQL(showBoatQuery);

            Console.WriteLine("Vilken båt vill du ta bort..?");
            int userBoatChoice = int.Parse(Console.ReadLine());

            string deleteBoatQuery = "CALL `deleteBoat`" + "(" + userBoatChoice + ");";
            SQLconnection.DeleteBoatSQL(deleteBoatQuery);

            Console.Clear();
            Presentation.BoatIsDeleted();
            Program.ContinueOnKeyPressed();
        }
    }
}
