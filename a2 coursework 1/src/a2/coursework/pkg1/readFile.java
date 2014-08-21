package a2.coursework.pkg1;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class readFile {
    
    private String path;
    
    public readFile(String filePath){
        path = filePath;
        System.out.println("path declared, path: " + path);
    }
    
    public String[] openFile() throws IOException{
        
        
        FileReader fr = new FileReader(path);        
        BufferedReader textReader = new BufferedReader(fr);
        System.out.println("file opened");
        
        int numLines = readLines();
        String tempWord ="";
        String tempLine;
        ArrayList<String> textArray = new ArrayList<String>();
        
        
        int k = 0;
        for (int i=0; i < numLines; i++) {
            System.out.println("loop #" + i);
            tempLine = textReader.readLine();
            for (int j = 0; j < tempLine.length(); j++){
            if (tempLine.charAt(j) != '-'){
                tempWord = tempWord + tempLine.charAt(j);                
            }
            else{
                textArray.add(tempWord);
                tempWord = "";
                k++;
            }
        }        
    }
    
    textReader.close();
    
    String[] textData = textArray.toArray(new String[0]);
    return textData;
    

}
    int readLines() throws IOException {
        System.out.println("readLines began");
        FileReader fileToRead = new FileReader (path);
        BufferedReader br = new BufferedReader(fileToRead);
        
        String aLine;
        int numberOfLines = 0;
        
        while ((aLine = br.readLine()) != null){
            numberOfLines++;
        }
        br.close();
        
        return numberOfLines;
    }
}
