/*
 * RunClub.java
 * Date: 9 Oktober, 2014
 * Created by: Robert Willem Hallink
 */
package YachtClub.Controller;
import YachtClub.Objects.Member;
import java.io.IOException;

/*
 * More Info Here!
 */
public class RunClub {
    
    /* Private Variable Fields */
    private final String filePath;
    private final YachtClub.View.Console console;
    private final YachtClub.Objects.Club club;
    
    
    
    /* Constructors ==> create new instance */
    public RunClub(String filePath, YachtClub.View.Console console, YachtClub.Objects.Club club) {   //Constructor starts
        
        this.filePath = filePath;
        this.console = console;
        this.club = club;
        
    }   //Constructor ends
    
    
    
    /* Main other methods */
    public void activate() {    //Method activate starts
        
        /* This is the main loop for the program after selecting a language until giving the order to quit */
        console.presentWelcomeMessage();
        while (console.isActive()) {
            console.presentInstructions();
            try                     { checkOrder(console.setInput()); }
            catch (IOException e)   { console.showError("input"); }
        }
    
    }   //Method active ends
    
    public void checkOrder(String input) throws IOException {   //Method checkOrder starts
        
        switch (input) {
            case "1":
                orderRegisterMember();
                return;
            case "2":
                orderUnregisterMember();
                return;
            case "3":
                orderEditMember();
                return;
            case "4":
                orderAddBoat();
                return;
            case "5":
                orderDeleteBoat();
                return;
            case "6":
                orderEditBoat();
                return;
            case "7":
                orderAssignBoat();
                return;
            case "8":
                orderUnassignBoat();
                return;
            case "9":
                orderShowCompactInfo();
                return;
            case "10":
                orderShowVerboseInfo();
        }
        
    }   //Method checkOrder ends
    
    
    
    /* Private help methods */
    private boolean isInteger(String string) {
        
        try {
            Integer.valueOf(string);
            return true;
        }
        catch (NumberFormatException e) { return false; }
    
    }
    
    
    
    /* Order methods (other methods) */
    public void orderShowCompactInfo()  { club.showCompactInfo(); }     //Method orderShowCompactInfo
    public void orderShowVerboseInfo()  { club.showVerboseInfo(); }     //Method orderShowVerboseInfo
    
    public void orderRegisterMember() throws IOException {   //Method orderAddMember starts
        
        console.showOrderInstructions("Register Member");
        String firstName = console.setInput();
        String lastName = console.setInput();
        String personNumber = console.setInput();
        club.registerMember(firstName, lastName, personNumber);
        Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        
    }   //Method orderAddMember ends
    
    public void orderUnregisterMember() throws IOException {    //Method orderUnregisterMember starts
        
        console.showOrderInstructions("Unregister Member");
        String remove = console.setInput();
        
        if (isInteger(remove))                                  //Check if input is an integer value for ID
            club.unregisterMember(Integer.parseInt(remove));    //Convert it into an integer
        else club.unregisterMember(remove);                     //Otherwise remove member by person number
        
        Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        
    }   //Method orderUnregisterMember ends
    
    public void orderEditMember() throws IOException {  //Method orderEditMember starts
        
        console.showOrderInstructions("Edit Member");
        String ID = console.setInput();
        String newFirstName = console.setInput();
        String newLastName = console.setInput();
        String newPersonNumber = console.setInput();
        
        if (isInteger(ID)) {
            club.editMember(0, newFirstName, newLastName, newPersonNumber);
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderEditMember ends
    
    public void orderAddBoat() throws IOException {     //Method addBoat starts
        
        console.showOrderInstructions("Add Boat");
        String type = console.setInput();
        String length = console.setInput();
        
        if (isInteger(length)) {
            club.addBoat(type, Integer.parseInt(length));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input"); 
        
    }    //Method addBoat ends
    
    public void orderDeleteBoat() throws IOException {  //Method orderDeleteBoat starts
        
        console.showOrderInstructions("Delete Boat");
        String ID = console.setInput();
        
        if (isInteger(ID)) {
            club.deleteBoat(Integer.parseInt(ID));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderDeleteBoat ends
    
    public void orderEditBoat() throws IOException {    //Method orderEditBoat starts
        
        console.showOrderInstructions("Edit Boat");
        String ID = console.setInput();
        String newType = console.setInput();
        String newLength = console.setInput();
        
        if (isInteger(ID) && isInteger(newLength)) {
            club.editBoat(Integer.parseInt(ID), newType, Integer.parseInt(newLength));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderEditBoat ends
    
    public void orderAssignBoat() throws IOException {  //Method orderAssignBoat starts
        
        console.showOrderInstructions("Assign Boat");
        String ID = console.setInput();
        String personNumber = console.setInput();
        
        if (isInteger(ID)) {
            Member member = null;
            for (int i=0; i<club.getMembers().size(); i++)
                if (club.getMembers().get(i).getPersonNumber().equals(personNumber)) {
                    member = club.getMembers().get(i);
                    break;
                }
            if (member != null) {
                club.assign(Integer.parseInt(ID), member);
                Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
            }
            else console.showError("member does not exist");
        }
        else console.showError("input");
        
    }   //Method orderAssignBoat ends
    
    public void orderUnassignBoat() throws IOException {    //Method orderUnassignBoat starts
        
        console.showOrderInstructions("Unassign Boat");
        String ID = console.setInput();
        
        if (isInteger(ID)) {
            club.unassign(Integer.parseInt(ID));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderUnassignBoat ends
    
}   //Class RunClub ends
