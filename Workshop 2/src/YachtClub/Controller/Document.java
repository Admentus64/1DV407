/*
 * Document.java
 * Date: 9 Oktober, 2014
 * Author: Robert Willem Hallink
 */
package YachtClub.Controller;
import YachtClub.Objects.Boat;
import YachtClub.Objects.Member;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * More Info Here!
 */
public class Document {
    
    /* Static methods */
    public static ArrayList<Member> readMembers(ArrayList<String> input) {  //Method readMembers starts
        
        ArrayList<Member> output = new ArrayList<>();
        input.stream().forEach((String line) -> {
            
            String firstName = line.substring(0, line.indexOf(' '));
            
            line = line.substring(firstName.length()+1);
            String lastName = line.substring(0, line.indexOf(' '));
            
            line = line.substring(lastName.length()+1);
            String personNumber = line.substring(0);
            
            output.add(new Member(firstName, lastName, personNumber));
        });
        return output;
        
    }   //Method readMembers ends
    
    public static ArrayList<Boat> readBoats(ArrayList<String> input, ArrayList<Member> members) {   //Method readBoats starts
        
        ArrayList<Boat> output = new ArrayList<>();
        input.stream().forEach((String line) -> {
            
            String type = line.substring(0, line.indexOf(' '));
            
            line = line.substring(type.length()+1);
            int length = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            
            line = line.substring(Integer.toString(length).length()+1);
            String memberNumber = line.substring(0);
            
            output.add(new Boat(type, length));
            if (!memberNumber.equals("null"))
                for (Member member : members)
                    if (member.getPersonNumber().equals(memberNumber)) {
                        output.get(output.size()-1).assign(member);
                        member.addBoat();
                        break;
                    }
            
        });
        return output;
        
    }   //Method readBoats ends
    
    public static ArrayList<String> readList(Scanner fileScan, String check, String path) throws IOException {  //Static method readList starts
        
        String strLine;
        ArrayList<String> output = new ArrayList<>();
        boolean active = false;
        
        fileScan = new Scanner(new FileReader(path));
        while (fileScan.hasNextLine()) {
            strLine = fileScan.nextLine();
            if (strLine.equals("---START " + check + "---"))
                active = true;
            else if (strLine.equals("---END " + check + "---"))
                active = false;
            else if (active)
                output.add(strLine);
            }
	return output;
        
    }   //Static method readList ends
    
    public static void parseIntoTextFile(String path, ArrayList<Member> members, ArrayList<Boat> boats) throws UnsupportedEncodingException, IOException {   //Static method parseIntoTextFile starts
        
        fileExists(path);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path), false)) ) {
            writer.write("---START MEMBERS---");
            writer.newLine();
            for (Member member : members) {
                writer.write(member.getFirstName() + " " + member.getLastName() + " " + member.getPersonNumber());
                writer.newLine();
            }
            writer.write("---END MEMBERS---");
            
            writer.newLine();
            
            writer.write("---START BOATS---");
            writer.newLine();
            for (Boat boat : boats) {
                if (boat.hasMember())
                    writer.write(boat.getType() + " " + boat.getLength() + " " + boat.getMemberNumber());
                else writer.write(boat.getType() + " " + boat.getLength() + " null");
                writer.newLine();
            }
            writer.write("---END BOATS---");
            
            writer.close();
        }
        
    }   //Static method parseIntoTextFile ends
    
    public static boolean fileExists(String path) {     //Static method FileExists starts
        
        File f = new File(path);
        if (f.exists() && !f.isDirectory())
            return true;
        
        //File and folder does not exist, return false and recreate folder.
        f = new File(path.substring(0, path.lastIndexOf('/')));
        f.mkdirs();
        return false;
        
    }   //Static method FileExists ends
    
}
