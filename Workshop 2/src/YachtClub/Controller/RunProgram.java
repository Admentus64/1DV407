/*
 * RunProgram.java
 * Date: 9 Oktober, 2014
 * Created by: Robert Willem Hallink
 */
package YachtClub.Controller;
import YachtClub.Objects.Boat;
import YachtClub.Objects.Club;
import YachtClub.Objects.Member;
import YachtClub.View.Console;
import YachtClub.View.ConsoleEng;
import YachtClub.View.ConsoleSwe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * More Info Here!
 */
public class RunProgram {     //Class RunProgram starts
    
    /* Private Variable Fields */
    private static final String path = "Data/Club.txt";
    
    
    
    /* Main method */
    public static void main(String[] args) throws IOException {    //Method main starts
        
        Scanner scan = new Scanner(System.in);
        Console console = selectLanguage(scan);
        Club club;
        if (Document.fileExists(path))
            club = loadData(console);
        else {
            Document.createFile(path);
            club = new Club(console);
        }
        
        RunClub runClub = new RunClub(path, console, club);
        runClub.activate();
        
    }   //Method main ends
    
    
    
    /* Private static help methods */
    private static Club loadData(Console console) {     //Method loadData starts
        
        Scanner fileScan = null;
        try {
            ArrayList<String> memberList = Document.readList(fileScan, "MEMBERS", path);
            ArrayList<String> boatList = Document.readList(fileScan, "BOATS", path);
            ArrayList<Member> members = Document.readMembers(memberList);
            ArrayList<Boat> boats = Document.readBoats(boatList, members);
            return new Club(members, boats, console);
        }
        catch(Exception e) {
            console.showError("load");
            return new Club(console);
        }
        finally {
            if (fileScan != null)
                fileScan.close();
        }
        
    }   //Method loadData ends
    
    private static Console selectLanguage(Scanner scan) {   //Method selectLanguage starts
        
        String language = "";
        while (!language.equals("en") && !language.equals("sv")) {
            System.out.print("Select a language (en) / Ange ett språk (sv): ");
            language = scan.nextLine();
            if (!language.equals("en") && !language.equals("sv"))
                System.out.println(language + " is not a valid language / är ej giltig språk");
        }
        
        switch (language) {
            case "en":
                return new ConsoleEng(scan);
            case "sv":
                return new ConsoleSwe(scan);
            default:                            //Always use english language when in an uncertain situation
                return new ConsoleEng(scan);
        }
        
    }   //Method selectLanguage ends
    
}   //Class RunProgram ends