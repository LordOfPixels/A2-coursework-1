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
                currentPosition = ParseNameId(eventString, currentPosition, event);
                System.out.println(event.getDate() + "-" + event.getName() + "-" + event.getSteamId());
            }                        
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static int ParseDate(String eventString, int position, Event event) throws ParseException{
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
    
    private static int ParseNameId(String eventString, int position, Event event) throws ParseException{
        int returnPosition = 0;
        int numOfSpchMks = 0;
        String name = "";
        String num = "";
        String steamId = "";
        String team = "";
        int part = 0;
        for (int j = position; j < eventString.length(); j++){
            char currentChar = eventString.charAt(j);
            returnPosition = j;
            if (currentChar == '"' && numOfSpchMks != 2){
                part = 1;
                numOfSpchMks ++;
            }
            else if (numOfSpchMks == 2){
                break;
            }

            if (currentChar == '<'){
                part ++;
            }
            else if (currentChar == '>'){
            }
            else if (part == 1){
                name += currentChar;
            }
            else if (part == 2){
                num += currentChar;
            }
            else if (part == 3){
                steamId += currentChar;
            }
            else if (part == 4){
                team += currentChar;
            }

        }
        event.setName(name);
        event.setSteamId(steamId);
        return returnPosition;
    }
    private static int ParseAction(String eventString, int position, Event event) throws ParseException{
        String Action = "";
        position = position++;
        int returnPosition = position;
        
        for (int j = position; j < eventString.length(); j++){
        returnPosition++;
        char currentChar = eventString.charAt(j);
            while (currentChar != '"'){
                Action += currentChar;
            }
            if (Action == "triggered "){
                
            }
            else if (Action == "killed "){
                Frag frag;
                String Victim = "";
                for (int i = returnPosition; i< eventString.length(); i++){
                    returnPosition++;
                    while (currentChar != '"'){
                        Victim += currentChar;
                    }
                    frag._victim = Victim;
                }
            }
        }
        return returnPosition;
    }
}
