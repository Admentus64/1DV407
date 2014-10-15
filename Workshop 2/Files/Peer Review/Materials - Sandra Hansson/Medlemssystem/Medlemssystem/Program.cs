using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Data;

namespace Medlemssystem
{

    /// <summary>
    /// This is an application create by Sandra Hanson and Jonas Holte WP13
    /// for the course "Objektorienterad analys och design med UML"
    /// </summary>
    class Program
    {
        public static void Menu()
        {
            SQLconnection conn = new SQLconnection();
            bool exit = false;
            do
            {
                switch (GetMenuChoice())
                {
                    case 0: { return; }
                    case 1: { addUser(); exit = true; break; }
                    case 2: { AddBoatToUser(); break; }
                    case 3: { ShowUsers(); ContinueOnKeyPressed(); break; }
                    case 4: { ShowCompleteUser(); break; }
                    case 5: { EditUsers(); break; }
                    case 6: { EditBoats(); break; }
                    case 7: { DeleteUsers(); break; }
                    case 8: { DeleteBoats(); break; }

                }
            } while (!exit);
        }

        static void Main(string[] args)
        {
            Menu();
        }

        public static void ContinueOnKeyPressed()
        {
            Console.ReadKey();
        }

        public static void addUser()
        {
            AddUser.addUser();
        }

        public static void EditBoats()
        {
            EditBoat.EditBoats();
        }

        public static void ShowCompleteUser()
        {
            ShowUser.ShowCompleteUser();
        }
        public static void DeleteBoats()
        {
            DeleteBoat.DeleteBoats();
        }

        public static void AddBoatToUser()
        {
            AddBoat.AddBoatToMember();
        }

        public static void EditUsers()
        {
            EditUser.EditUserInfo();
        }

        public static void ShowUsers()
        {
            ShowUser.ShowUsers();
        }

        public static void DeleteUsers()
        {
            Delete.DeleteUsers();
        }

        static int GetMenuChoice()
        {
            Presentation.GetMenu();
            do
            {
                int menuChoice;

                //Läser av värdet i menyn och "outar" det valet till menyChoice, valet måste va inom 0-11 annars felmed.
                if (int.TryParse(Console.ReadLine(), out menuChoice) && (menuChoice >= 0 && menuChoice <= 11))
                {
                    Console.Clear();
                    return menuChoice;
                }
                else
                {
                    Menu();
                }
            } while (true);
        }
    }
}