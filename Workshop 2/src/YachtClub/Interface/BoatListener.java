/*
 * BoatListener.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Interface;

/*
 * More Info Here!
 */
public interface BoatListener {    //Interface BoatListener starts
    
    public String getType();            //Method getType
    public int getLength();             //Method getLength
    public int getID();                 //Method getID
    public String getMemberNumber();    //Method getMemberNumber
    public boolean hasMember();         //Method hasMember
    
    public void edit(String a, int i);  //Method edit
    public void setType(String a);      //Method setType
    public void setLength(int i);       //Method setLength
    
    public void assign(String s);       //Method assign
    public void unassign();             //Method unassign
    
}   //Interface BoatListener starts