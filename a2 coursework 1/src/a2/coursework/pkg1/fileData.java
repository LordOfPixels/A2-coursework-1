package a2.coursework.pkg1;
import java.io.IOException;

public class fileData {
    
    
    public static void main(String[] args)throws IOException {
        
        String fileName = "C:\\git\\a2-coursework-1\\log.log";
        System.out.println("Run Main");
        String[] allLines;
        try {
            System.out.println("Succesfully  tried");
            readFile file = new readFile(fileName);
            allLines = file.openFile();
            for (String allLine : allLines) {
                System.out.println(allLine);
            }
        
            for (String allLine : allLines){
                
            }
                        
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
