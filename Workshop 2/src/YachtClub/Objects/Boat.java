/*
 * Boat.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Objects;
import YachtClub.Interface.BoatListener;

/*
 * More Info Here!
 */
public class Boat implements BoatListener {     //Class Boat starts
    
    /* Private Variable Fields */
    private String type = "";
    private int length = 0;
    private String linkedNumber = null;
    private static int count = 0;
    private final int ID;
    
    
    
    /* Constructors ==> create new instance */
    public Boat(String type, int length) {  //Constructor starts
        
        this.type = type;
        if (length > 0)
            this.length = length;
        this.ID = count++;
        
    }   //Constructor ends
    
    
    
    /* Accessors ==> read object states */
    @Override   public String getType()             { return type; }                        //Method getType
    @Override   public int getLength()              { return length; }                      //Method getLength
    @Override   public int getID()                  { return ID; }                          //Method getID
    @Override   public String getMemberNumber()     { return linkedNumber; }                //Method getMemberNumber
    @Override   public boolean hasMember()          { return linkedNumber != null; }        //Method hasMember
    
    
    
    /* Mutators ==> update object states */
    @Override   public void setType(String type)    { this.type = type; }       //Method setType                 
    
    @Override
    public void setLength(int length) {     //Method setLength starts
        
        if (length > 0)
            this.length = length;
        
    }   //Method setLength ends
    
    @Override
    public void edit(String type, int length) {     //Method edit starts
        
        this.type = type;
        setLength(length);
        
    }   //Method edit ends
    
    
    
    /* Other methods */
    @Override
    public void assign(String memberNumber) {     //Method assign starts
        
        if (linkedNumber == null)
            linkedNumber = memberNumber;
        
    }   //Method assign ends
    
    @Override
    public void unassign() {    //Method unassign starts
        
        if (linkedNumber != null)
            linkedNumber = null;
        
    }   //Method unassign ends
    
}   //Class Boat ends