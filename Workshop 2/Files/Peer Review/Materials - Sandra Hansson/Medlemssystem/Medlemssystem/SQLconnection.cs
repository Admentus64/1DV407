using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Data;

namespace Medlemssystem
{
    class SQLconnection
    {
        public static void con(string sqlQuery)
        {
            MySqlConnectionStringBuilder connBuilder = new MySqlConnectionStringBuilder();

            connBuilder.Add("Database", "boatclub");
            connBuilder.Add("Data Source", "127.0.0.1");
            connBuilder.Add("User Id", "root");
            connBuilder.Add("Password", "");

            MySqlConnection connection = new MySqlConnection(connBuilder.ConnectionString);

            MySqlCommand cmd = connection.CreateCommand();

            connection.Open();

            cmd.CommandText = sqlQuery; 
            cmd.CommandType = CommandType.Text;

            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(String.Format("{0}. {1} {2} - {3}",
                reader.GetInt32(0), reader.GetString(1), reader.GetString(2), reader.GetString(3))
                );
            }
            reader.Close();
        }


        public static void Procedure(string sqlQuery)
        {
            MySqlConnectionStringBuilder connBuilder = new MySqlConnectionStringBuilder();

            connBuilder.Add("Database", "boatclub");
            connBuilder.Add("Data Source", "127.0.0.1");
            connBuilder.Add("User Id", "root");
            connBuilder.Add("Password", "");

            MySqlConnection connection = new MySqlConnection(connBuilder.ConnectionString);

            MySqlCommand cmd = connection.CreateCommand();

            connection.Open();

            cmd.CommandText = sqlQuery;
            cmd.CommandType = CommandType.Text;

            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(String.Format("{0} {1} - {2}: {3} {4} {5}",
                    reader.GetInt32(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5))
                );
            }
            Console.ReadLine();

            reader.Close();
        }

        public static void DeleteBoatSQL(string sqlQuery)
        {
            MySqlConnectionStringBuilder connBuilder = new MySqlConnectionStringBuilder();

            connBuilder.Add("Database", "boatclub");
            connBuilder.Add("Data Source", "127.0.0.1");
            connBuilder.Add("User Id", "root");
            connBuilder.Add("Password", "");

            MySqlConnection connection = new MySqlConnection(connBuilder.ConnectionString);

            MySqlCommand cmd = connection.CreateCommand();

            connection.Open();

            cmd.CommandText = sqlQuery;
            cmd.CommandType = CommandType.Text;

            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(String.Format("{0} {1} {2}",
                    reader.GetInt32(0), reader.GetString(1), reader.GetString(2))
                );
            }
            reader.Close();
        }

        public static void addBoatconn(string sqlQuery)
        {
            MySqlConnectionStringBuilder connBuilder = new MySqlConnectionStringBuilder();

            connBuilder.Add("Database", "boatclub");
            connBuilder.Add("Data Source", "127.0.0.1");
            connBuilder.Add("User Id", "root");
            connBuilder.Add("Password", "");

            MySqlConnection connection = new MySqlConnection(connBuilder.ConnectionString);

            MySqlCommand cmd = connection.CreateCommand();

            connection.Open();

            cmd.CommandText = sqlQuery;
            cmd.CommandType = CommandType.Text;

            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {                
                Console.WriteLine(String.Format("{0}. {1} {2}",
                     reader.GetInt32(0), reader.GetString(1), reader.GetString(2))
                 );
            }
             reader.Close();
        }
        public static void showCompressedList(string sqlQuery)
        {
            MySqlConnectionStringBuilder connBuilder = new MySqlConnectionStringBuilder();

            connBuilder.Add("Database", "boatclub");
            connBuilder.Add("Data Source", "127.0.0.1");
            connBuilder.Add("User Id", "root");
            connBuilder.Add("Password", "");

            MySqlConnection connection = new MySqlConnection(connBuilder.ConnectionString);

            MySqlCommand cmd = connection.CreateCommand();

            connection.Open();

            cmd.CommandText = sqlQuery;
            cmd.CommandType = CommandType.Text;

            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine(String.Format("{0}.\t {1} {2} \t {3} \t {4}",
                     reader.GetInt32(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetInt32(4))
                 );
            }
            reader.Close();
        }
    }
}
