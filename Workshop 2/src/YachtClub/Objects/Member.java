/*
 * Member.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Objects;
import YachtClub.Interface.MemberListener;

/*
 * More Info Here!
 */
public class Member implements MemberListener  {   //Class Member starts
    
    /* Private Variable Fields */
    private String firstName = "";
    private String lastName = "";
    private String personNumber = "";
    private int boats = 0;
    private static int count = 0;
    private final int ID;
    
    
    
    /* Constructors ==> create new instance */
    public Member(String firstName, String lastName, String personNumber) {   //Constructor starts
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.personNumber = personNumber;
        ID = count++;
        
    }   //Constructor ends
    
    
    
    /* Accessors ==> read object states */
    @Override   public String getFirstName()            { return firstName; }       //Method getFirstName
    @Override   public String getLastName()             { return lastName; }        //Method getFirstName
    @Override   public String getPersonNumber()         { return personNumber; }    //Method getPersonNumber
    @Override   public int getID()                      { return ID; }              //Method getID
    @Override   public int getBoats()                   { return boats; }           //Method getBoats
    
    
    
    /* Mutators ==> update object states */
    @Override   public void addBoat()                               { boats++; }                            //Method addBoat
    @Override   public void setPersonNumber(String personNumber)    { this.personNumber = personNumber; }   //Method setPersonNumber
    
    @Override
    public void setName(String firstName, String lastName) {    //Method setName starts
        
        this.firstName = firstName;
        this.lastName = lastName;
        
    }   //Method setName ends
    
    @Override
    public void edit(String firstName, String lastName, String personNumber) {    //Method edit starts
        
        setName(firstName, lastName);
        this.personNumber = personNumber;
        
    }   //Method edit ends
    
    @Override
    public void removeBoat() {  //Method removeBoat starts
        
        if (boats > 0)
            boats--;
        
    }   //Method removeBoat ends
    
    @Override
    public void setBoats(int boats) {   //Method setBoats starts
        
        if (boats >= 0)
            this.boats = boats;
        
    }   //Method setBoats ends
    
}   //Class Member ends