package a2.coursework.pkg1;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class fileData {
    
    
    public static void main(String[] args)throws IOException, ParseException {
        
        String fileName = "C:\\git\\a2-coursework-1\\log.log";
        System.out.println("Run Main");
        String[] events;
        try {
            System.out.println("Succesfully  tried");
            readFile file = new readFile(fileName);
            events = file.openFile();
            Map<String, Player> map = new HashMap<String, Player>();
        // L 08/14/2014 - 21:58:22: "sheepy<28><STEAM_0:1:40009526><Blue>" triggered "damage" against "iM snowblind intel @ UK<23><STEAM_0:1:1547596><Red>" (damage "27") (weapon "scattergun")
        // L 08/14/2014 - 21:56:26: "AwS kaidus<3><STEAM_0:1:1524315><Blue>" picked up item "medkit_medium" (healing "88")
            for (String eventString : events){
                System.out.println(eventString);
                // This starts at 1 so we skip the leading L in every line
                Event event = new Event();
                int currentPosition = 1;
                currentPosition = ParseDate(eventString, currentPosition, event);
                
                System.out.println(event.getDate());
            }                        
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static int ParseDate(String eventString, int position, Event event) throws ParseException
    {
        int colonCount = 0;
        String dateString = "";
        int returnPosition = 0;
        for (int j = position; j < eventString.length(); j++){
            char currentChar = eventString.charAt(j);
            returnPosition = j;
            
            if (currentChar == ':'){
                colonCount ++;
            }

            if (colonCount < 3){
                dateString += currentChar;
            }
            else
            {
                DateFormat df = new SimpleDateFormat(" MM/dd/yyyy - kk:mm:ss");
                event.setDate(df.parse(dateString));
                break;
            }                    
        }
        
        return returnPosition;
    }
}
