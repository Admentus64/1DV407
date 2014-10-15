using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Data;

namespace Medlemssystem
{
    class ShowUser
    {
        public static void ShowUsers()
        {
            Presentation.ListMembers();
            string displayAllUsers = "CALL `miniMemList`();";
            SQLconnection.showCompressedList(displayAllUsers);
        }

        public static void ShowCompleteUser()
        {
            Presentation.ListAllMembers();
            string callProcedure = "CALL `memberlist`();";
            SQLconnection.Procedure(callProcedure);
        }
    }
}