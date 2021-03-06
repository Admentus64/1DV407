/*
 * ConsoleSwe.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.View;
import java.util.Scanner;

/*
 * More Info Here!
 */
public class ConsoleSwe extends Console { //Class ConsoleSwe starts
    
    /* Constructors ==> create new instance */
    public ConsoleSwe(Scanner scan)     { super(scan); }    //Constructor
    
    
    
    /* Other methods */
    @Override
    public void presentWelcomeMessage() {   //Method presentWelcomeMessage starts
        
        System.out.println("Hej, Båtblubbs Chef. Gärna välj en order.");
        
    }   //Method presentWelcomeMessage ends
    
    @Override
    public void presentInstructions() {     //Method presentInstructions starts
        
        System.out.println("(1) Registrera medlem. (2) Avregistrera medlem. (3) Ändra medlem. (4) Lägg till båt. (5) Ta bort båt. (6) Ändra boat. (7) Tilldela båt. (8) Ta bort tilldelning av båt. (9) Visa kompakt info. (10) Visa fullständig info. (Q) Sluta.");
        System.out.print("Välj order: ");
        
    }   //Method presentInstructions ends
    
    @Override
    public void showOrderInstructions(String order) {   //Method showOrderInstructions starts
        
        switch (order) {
            case "First Name":
                System.out.print("Ange förnamn: ");
                break;
            case "Last Name":
                System.out.print("Ange efternamn: ");
                break;
            case "Person Number":
                System.out.print("Ange personnummer: ");
                break;
            case "Type":
                System.out.print("Ange typ: ");
                break;
            case "Length":
                System.out.print("Ange längd i cm: ");
                break;
            case "Member ID":
                System.out.print("Ange medlem ID: ");
                break;
            case "Boat ID":
                System.out.print("Ange båt ID: ");
                break;
            case "Member ID / Person Number":
                System.out.print("Ange medlem ID eller personnummer: ");
                break;
            default:
                System.out.print("Okänd order: ");
        }
        
    }   //Method showOrderInstructions ends
    
    @Override
    public void showError(String err) {     //Method showError starts
        
        switch (err) {
            case "input":
                System.err.println("Fel med inmattning. Avbryta order, försök igen gärna.");
                break;
            case "load":
                System.err.println("Fel med läsa data. Återställar data nu!");
                break;
            case "write":
                System.err.println("Fel med skriva fil. Avbryta order, försök igen gärna.");
                break;
            case "does not exist":
                System.err.println("Objekt finns ej. Avbryta order, försök igen gärna.");
                break;
            case "member does not exist":
                System.err.println("Medlem finns ej. Avbryta order, försök igen gärna.");
                break;
            case "boat does not exist":
                System.err.println("Båt finns ej. Avbryta order, försök igen gärna.");
                break;
            case "unassign":
                System.err.println("Boat has no assigned member. Avbryta order, försök igen gärna.");
                break;
            case "assign":
                System.err.println("Boat is already assigned to a member. Avbryta order, försök igen gärna.");
                break;
            case "number":
                System.err.println("Personnumber already exists for a member. Avbryta order, försök igen gärna.");
                break;
            case "negative ID":
                System.err.println("ID får inte har ett negativt värde. Avbryta order, försök igen gärna.");
                break;
            case "not-positive length":
                System.err.println("Längden av båten krävs ett positivt värde. Avbryta order, försök igen gärna.");
                break;
            case "no members":
                System.err.println("Inga medlemmar finns. Avbryta order, försök igen gärna.");
                break;
            case "no boats":
                System.err.println("Inga båtar finns. Avbryta order, försök igen gärna.");
                break;
            default:
                System.err.println("Okänd fel. Avbryta order, försök igen gärna.");
        }
        
    }   //Method showError ends
    
    @Override
    public String print(String object) {    //Method print starts
        
        switch (object) {
            case "member":
                return "(Medlem)";
            case "name":
                return "Namn: ";
            case "number":
                return "Personummer: ";
            case "boats":
                return "Båtar: ";
            case "boat":
                return "(Båt)   ";
            case "type":
                return "Typ: ";
            case "length":
                return "Längd: ";
            case "member number":
                return "Medlem Personnummer: ";
            case "ID":
                return "ID: ";
            default:
                return "(?)";
        }
        
    }   //Method print ends
    
    @Override
    public void showEmptyList(String contents) {    //Method showEmptyList starts
        
        switch (contents) {
            case "members":
                System.out.println("Inga medlemmar är registrerat än.");
                break;
            case "boats":
                System.out.println("Inga båtar är registrerat än.");
                break;
            default:
                System.out.println("Okänd lista: ");
        }
        
    }   //Method showEmptyList ends
    
}   //Class ConsoleSwe ends