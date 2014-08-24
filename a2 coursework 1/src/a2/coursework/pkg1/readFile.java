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
        BufferedReader br = new BufferedReader(fr);
        String aLine;
        ArrayList<String> textData = new ArrayList<String>();
        
        while ((aLine = br.readLine()) != null){
               textData.add(aLine);
        }

        textReader.close();
    
        return textData.toArray(new String[0]);
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
