using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medlemssystem
{
    class Presentation
    {

        public static void GetMenu()
        {
            //visar en grundmeny
            Console.Clear();
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("===============================");
            Console.WriteLine("  Båtklubben MemberSystem v.3.2");
            Console.WriteLine("===============================");
            Console.ResetColor();
            Console.WriteLine("");
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                Menyval               =");
            Console.WriteLine("= --Arkiv----------------------------- =");
            Console.WriteLine("=    0. Avsluta.                       =");
            Console.WriteLine("=    1. Lägg till användare            =");
            Console.WriteLine("=    2. Lägg till båt                  =");
            Console.WriteLine("=    3. Kortfattad lista av medlemmar. =");
            Console.WriteLine("=    4. Komplett lista av medlemmar.   =");
            Console.WriteLine("= --Redigera-------------------------- =");
            Console.WriteLine("=    5. Editera Användare              =");
            Console.WriteLine("=    6. Editera Båt                    =");
            Console.WriteLine("= --Ta bort--------------------------- =");
            Console.WriteLine("=    7. Ta bort Användare              =");
            Console.WriteLine("=    8. Ta bort Båt                    =");
            Console.WriteLine("= ==================================== =");
            Console.WriteLine("=          Ange menyval [0-8]          =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
            Console.Write("Skriv in ditt val: ");
        }

        public static void ListMembers()
        {
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=     Kortfattad lista av medlemmar    =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void ListAllMembers()
        {
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=     Komplett lista av medlemmar      =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void UserIsAdded()
        {
            Console.BackgroundColor = ConsoleColor.DarkYellow;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Användare tillagd             =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void Adduser()
        {
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Lägg till användare           =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void BoatIsAdded()
        {
            Console.BackgroundColor = ConsoleColor.DarkYellow;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Båt tillagd                   =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void BoatIsEdited()
        {
            Console.BackgroundColor = ConsoleColor.DarkYellow;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Båt tillagd                   =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void AddBoat()
        {
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Lägg till båt                 =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void BoatIsDeleted()
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Båt togs bort                 =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void DeletePresentation()
        {
            Console.BackgroundColor = ConsoleColor.DarkRed;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=  Vilken användare vill du ta bort?   =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void UserIsDeleted()
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=        Användaren togs bort          =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }

        public static void UserIsNotDeleted()
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=     Ingen Användaren togs bort       =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void EditUsers()
        {
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=         Editera användare            =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
        public static void MemberIsEdit()
        {
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=         Användaren är editerad       =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }

        public static void UserListFull()
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine("========================================");
            Console.WriteLine("=                                      =");
            Console.WriteLine("=   Inga platser finns i systemet.     =");
            Console.WriteLine("=                                      =");
            Console.WriteLine("========================================\n");
            Console.ResetColor();
        }
    }
}
