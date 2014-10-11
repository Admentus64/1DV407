/*
 * BoatListener.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Interface;
import YachtClub.Objects.Boat;
import YachtClub.Objects.Member;
import java.util.ArrayList;

/*
 * More Info Here!
 */
public interface ClubListener {    //Interface BoatListener starts
    
    /* Lists */
    public ArrayList<Member> getMembers();                                      //Method getMembers
    public ArrayList<Boat> getBoats();                                          //Method getBoats
    
    /* Members */
    public Member getMember(String personNumber);                                               //Method getMember (uses person number)
    public Member getMember(int ID);                                                            //Method getMember (uses ID)
    public void registerMember(String firstName, String lastName, String personNumber);         //Method registerMember
    public void unregisterMember(String personNumber);                                          //Method unregisterMember (uses person number)
    public void unregisterMember(int ID);                                                       //Method unregisterMember (uses ID)
    public void editMember(int ID, String firstName, String lastName, String personNumber);     //Method editMember
    
    /* Boats */
    public Boat getBoat(int ID);                                                //Method getBoat
    public void addBoat(String type, int length);                               //Method addBoat
    public void deleteBoat(int ID);                                             //Method deleteBoat
    public void editBoat(int ID, String type, int length);                      //Method editBoat
    
    /* Assigning */
    public void assign(int i, Member m);                                        //Method assign
    public void unassign(int i);                                                //Method unassign
    
    /* Info */
    public void showCompactInfo();                                              //Method showCompactInfo
    public void showVerboseInfo();                                              //Method showVerboseInfo
    
}   //Interface BoatListener starts