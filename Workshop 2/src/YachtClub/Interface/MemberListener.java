/*
 * MemberListener.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Interface;

/*
 * More Info Here!
 */
public interface MemberListener {    //Interface MemberListener starts
    
    public String getFirstName();           //Method getFirstName
    public String getLastName();            //Method getLastName
    public String getPersonNumber();        //Method getPersonNumber
    public int getID();                     //Method getID
    public int getBoats();                  //Method getBoats
    
    public void edit(String a, String b, String c);     //Method edit
    public void setName(String a, String b);            //Method setName
    public void setPersonNumber(String a);              //Method setPersonNumber
    
    public void setBoats(int i);            //Method setBoats
    public void addBoat();                  //Method addBoat
    public void removeBoat();               //Method removeBoat
    
}   //Interface MemberListener starts