/*
 * Club.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Objects;
import YachtClub.Interface.ClubListener;
import YachtClub.View.Console;
import java.util.ArrayList;

/*
 * More Info Here!
 */
public class Club  implements ClubListener  {     //Class Club starts
    
    /* Private Variable Fields */
    private final ArrayList<Member> members;
    private final ArrayList<Boat> boats;
    private final Console console;
    
    
    
    /* Constructors ==> create new instance */
    public Club(Console console) {  //Empty constructor starts
        
        this.members = new ArrayList<>();
        this.boats = new ArrayList<>();
        this.console = console;
        
    }   //Empty constructor ends
    
    public Club(ArrayList<Member> members, ArrayList<Boat> boats, Console console) {    //Full constructor starts
        
        this.members = members;
        this.boats = boats;
        this.console = console;
        
    }   //Full constructor ends
    
    /* Accessors ==> read object states */
    @Override   public ArrayList<Member> getMembers()   { return members; }     //Method getMembers
    @Override   public ArrayList<Boat> getBoats()       { return boats; }       //Method getBoats
    
    @Override
    public Member getMember(String personNumber) {  //Method getMember starts (uses person number)
        
        for (Member member : members)
            if (member.getPersonNumber().equals(personNumber))
                return member;
        return null;
        
    }   //Method getMember ends

    @Override
    public Member getMember(int ID) {   //Method getMember starts (uses ID)
        
        for (Member member : members)
            if (member.getID() == ID)
                return member;
        return null;
        
    }   //Method getMember ends
    
    @Override
    public Boat getBoat(int ID) {   //Method getBoat starts
        
        for (Boat boat : boats)
            if (boat.getID() == ID)
                return boat;
        return null;
        
    }   //Method getBoat ends
    
    
    
    /* Mutators ==> update object states */
    @Override
    public void registerMember(String firstName, String lastName, String personNumber) {  //Method registerMember starts
        
        if (personNumberExists(personNumber))
            return;
        members.add(new Member(firstName, lastName, personNumber));
        
    }   //Method registerMember ends

    @Override
    public void unregisterMember(String personNumber) {     //Method unregisterMember starts (uses person number)
        
        for (int i=0; i<members.size(); i++)
            if (members.get(i).getPersonNumber().equals(personNumber)) {
                removeRegisteredBoat(members.get(i));
                members.remove(i);
                return;
            }
        console.showError("member does not exist");
        
    }   //Method unregisterMember starts

    @Override
    public void unregisterMember(int ID) {  //Method unregisterMember starts (uses ID)
        
        for (int i=0; i<members.size(); i++)
            if (members.get(i).getID() == ID) {
                removeRegisteredBoat(members.get(i));
                members.remove(i);
                return;
            }
        console.showError("member does not exist");
        
    }   //Method unregisterMember ends

    @Override
    public void editMember(int ID, String firstName, String lastName, String personNumber) {  //Method editMember starts
        
        if (personNumberExists(personNumber))
            return;
        
        for (Member member : members)
            if (member.getID() == ID) {
                String oldNumber = member.getPersonNumber();
                member.edit(firstName, lastName, personNumber);
                for (Boat boat : boats)
                    if (boat.hasMember())
                        if (boat.getMemberNumber().equals(oldNumber)) {
                            boat.unassign();
                            boat.assign(member);
                            return;
                        }
                return;
            }
        console.showError("member does not exist");
        
    }   //Method editMember ends
    
    @Override
    public void addBoat(String type, int length) {  //Method addBoat starts
        boats.add(new Boat(type, length));
    }   //Method addBoat ends

    @Override
    public void deleteBoat(int ID) {    //Method deleteBoat starts
        
        for (int i=0; i<boats.size(); i++)
            if (boats.get(i).getID() == ID) {
                boats.remove(i);
                return;
            }
        console.showError("boat does not exist");
        
    }   //Method deleteBoat ends

    @Override
    public void editBoat(int ID, String type, int length) {     //Method editBoat starts
        
        for (Boat boat : boats)
            if (boat.getID() == ID) {
                boat.edit(type, length);
                return;
            }
        console.showError("boat does not exist");
        
    }   //Method editBoat ends
    
    
    
    /* Other methods */
    @Override
    public void assign(int ID, Member member) {     //Method assign starts
        
        for (Boat boat : boats)
            if (boat.getID() == ID) {
                if (boat.getMember() == null) {
                    boat.assign(member);
                    member.addBoat();
                    return;
                }
                else {
                    console.showError("assign");
                    return;
                }
            }
        console.showError("boat does not exist");
        
    }   //Method assign ends
    
    @Override
    public void unassign(int ID) {  //Method unassign starts
        
        for (Boat boat : boats)
            if (boat.getID() == ID) {
                if (boat.getMember() != null) {
                    boat.getMember().removeBoat();
                    boat.unassign();
                    return;
                }
                else {
                    console.showError("unassign");
                    return;
                }
            }
        console.showError("boat does not exist");
        
    }   //Method unassign ends
    
    @Override
    public void showCompactInfo() {     //Method showCompactInfo starts
        
        if (members.size() > 0) {
            members.stream().forEach((member) -> {
                System.out.println(showMemberInfo(member, false));
            });
        }
        else console.showEmptyList("members");
        
    }   //Method showCompactInfo ends
    
    @Override
    public void showVerboseInfo() {     //Method showVerboseInfo starts
        
        if (members.size() > 0) {
            members.stream().forEach((member) -> {
                System.out.println(showMemberInfo(member, true));
            });
        }
        else console.showEmptyList("members");
        
        if (boats.size() > 0) {
            boats.stream().forEach((boat) -> {
                System.out.println(showBoatInfo(boat));
            });
        }
        else console.showEmptyList("boats");
        
    }   //Method showVerboseInfo starts
    
    
    
    /* Private help methods */
    private String showMemberInfo(Member member, boolean verbose) {     //Method showMemberInfo starts
        
        String output = console.print("member") + "   ";
        output += console.print("name") + member.getFirstName();
        if (verbose) {
            output += " " + member.getLastName() + ", ";
            output += console.print("number") + member.getPersonNumber();
        }
        output += ", " + console.print("boats") + member.getBoats() + ", ";
        output += console.print("ID") + member.getID();
        return output;
        
    }   //Method showMemberInfo ends
    
    private String showBoatInfo(Boat boat) {    //Method showBoatInfo starts
        
        String output = console.print("boat") + "   ";
        output += console.print("type") + boat.getType() + ", ";
        output += console.print("length") + boat.getLength() + " cm, ";
        output += console.print("ID") + boat.getID();
        if (boat.hasMember())
            output += ", " + console.print("member number") + boat.getMemberNumber();
        return output;
        
    }   //Method showBoatInfo ends
    
    private void removeRegisteredBoat(Member member) {  //Method removeRegisteredBoat starts
        
        for (Boat boat : boats)
                    if (boat.getMemberNumber().equals(member.getPersonNumber())) {
                        boat.unassign();
                        return;
                    }
        
    }   //Method removeRegisteredBoat ends
    
    private boolean personNumberExists(String personNumber) {   //Method personNumberExists starts
        
        for (Member member : members) {
            if (member.getPersonNumber().equals(personNumber)) {
                console.showError("number");
                return true;
            }
        }
        return false;
        
    }   //Method personNumberExists ends
    
}   //Class Club ends