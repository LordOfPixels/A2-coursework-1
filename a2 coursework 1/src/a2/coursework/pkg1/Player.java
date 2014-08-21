package a2.coursework.pkg1;

import java.util.ArrayList;

public class Player 
{
    ArrayList<Frag> frags;
    
    public ArrayList<Frag> getFrags(){
        return frags;        
    }
    
    public void setFrags(Frag frag){
        frags.add(frag);
    }
}
