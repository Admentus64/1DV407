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
            try {
                checkOrder(console.setLineInput());
                if (console.getInput().equals("9") || console.getInput().equals("10"))
                    clearConsole(1);
                else clearConsole(5);
            }
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
    private void clearConsole(int lines) {   //Method clearConsole starts
        
        for (int i=0; i<lines; i++)
            System.out.println();
        
    }   //Method clearConsole ends
    
    private boolean isInteger(String string) {  //Method isInteger starts
        
        try {
            Integer.valueOf(string);
            return true;
        }
        catch (NumberFormatException e) { return false; }
    
    }   //Method isInteger ends
    
    
    
    /* Order methods (other methods) */
    public void orderShowCompactInfo()  { club.showCompactInfo(); }     //Method orderShowCompactInfo
    public void orderShowVerboseInfo()  { club.showVerboseInfo(); }     //Method orderShowVerboseInfo
    
    public void orderRegisterMember() throws IOException {   //Method orderAddMember starts
        
        console.showOrderInstructions("First Name");
        String firstName = console.setLineInput();
        
        console.showOrderInstructions("Last Name");
        String lastName = console.setLineInput();
        
        console.showOrderInstructions("Person Number");
        String personNumber = console.setLineInput();
        
        club.registerMember(firstName, lastName, personNumber);
        Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        
    }   //Method orderAddMember ends
    
    public void orderUnregisterMember() throws IOException {    //Method orderUnregisterMember starts
        
        if (club.getMembers().isEmpty()) {
            console.showError("no members");
            return;
        } 
        
        console.showOrderInstructions("Member ID / Person Number");
        String remove = console.setLineInput();
        
        int sizeMembers = club.getMembers().size();
        if (isInteger(remove))                                  //Check if input is an integer value for ID
            club.unregisterMember(Integer.parseInt(remove));    //Convert it into an integer
        if (sizeMembers == club.getMembers().size())
            club.unregisterMember(remove);                     //Otherwise remove member by person number
        if (sizeMembers == club.getMembers().size())
            console.showError("member does not exist");
        
        Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        
    }   //Method orderUnregisterMember ends
    
    public void orderEditMember() throws IOException {  //Method orderEditMember starts
        
        if (club.getMembers().isEmpty()) {
            console.showError("no members");
            return;
        } 
        
        console.showOrderInstructions("Member ID");
        String ID = console.setLineInput();
        
        console.showOrderInstructions("First Name");
        String newFirstName = console.setLineInput();
        
        console.showOrderInstructions("Last Name");
        String newLastName = console.setLineInput();
        
        console.showOrderInstructions("Person Number");
        String newPersonNumber = console.setLineInput();
        
        if (isInteger(ID)) {
            club.editMember(0, newFirstName, newLastName, newPersonNumber);
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderEditMember ends
    
    public void orderAddBoat() throws IOException {     //Method addBoat starts
        
        console.showOrderInstructions("Type");
        String type = console.setLineInput();
        
        console.showOrderInstructions("Length");
        String length = console.setLineInput();
        
        if (isInteger(length)) {
            club.addBoat(type, Integer.parseInt(length));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input"); 
        
    }    //Method addBoat ends
    
    public void orderDeleteBoat() throws IOException {  //Method orderDeleteBoat starts
        
        if (club.getBoats().isEmpty()) {
            console.showError("no boats");
            return;
        } 
        
        console.showOrderInstructions("Boat ID");
        String ID = console.setLineInput();
        
        if (isInteger(ID)) {
            club.deleteBoat(Integer.parseInt(ID));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderDeleteBoat ends
    
    public void orderEditBoat() throws IOException {    //Method orderEditBoat starts
        
        if (club.getBoats().isEmpty()) {
            console.showError("no boats");
            return;
        } 
        
        console.showOrderInstructions("Boat ID");
        String ID = console.setLineInput();
        
        console.showOrderInstructions("Type");
        String newType = console.setLineInput();
        
        console.showOrderInstructions("Length");
        String newLength = console.setLineInput();
        
        if (isInteger(ID) && isInteger(newLength)) {
            club.editBoat(Integer.parseInt(ID), newType, Integer.parseInt(newLength));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderEditBoat ends
    
    public void orderAssignBoat() throws IOException {  //Method orderAssignBoat starts
        
        if (club.getBoats().isEmpty()) {
            console.showError("no boats");
            return;
        }
        if (club.getMembers().isEmpty()) {
            console.showError("no members");
            return;
        }
        
        console.showOrderInstructions("Boat ID");
        String ID = console.setLineInput();
        
        console.showOrderInstructions("Member ID / Person Number");
        String assign = console.setLineInput();
        
        Member member = null;
        for (int i=0; i<club.getMembers().size(); i++) {
            if (isInteger(assign)) {
                member = club.getMembers().get(i);
                break;
            }
            else if (club.getMembers().get(i).getPersonNumber().equals(assign)) {
                member = club.getMembers().get(i);
                break;
            }
        }
        
        if (member != null) {
            club.assign(Integer.parseInt(ID), member);
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("member does not exist");
        
    }   //Method orderAssignBoat ends
    
    public void orderUnassignBoat() throws IOException {    //Method orderUnassignBoat starts
        
        if (club.getBoats().isEmpty()) {
            console.showError("no boats");
            return;
        }
        
        console.showOrderInstructions("Boat ID");
        String ID = console.setLineInput();
        
        if (isInteger(ID)) {
            club.unassign(Integer.parseInt(ID));
            Document.parseIntoTextFile(filePath, club.getMembers(), club.getBoats());
        }
        else console.showError("input");
        
    }   //Method orderUnassignBoat ends
    
}   //Class RunClub ends
