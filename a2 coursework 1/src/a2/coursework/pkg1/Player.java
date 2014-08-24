package a2.coursework.pkg1;

import java.util.ArrayList;

public class Player 
{
    ArrayList<Frag> frags;
    ArrayList<Damage> damages;
    ArrayList<Assist> assists;
    int heals;
    
    public ArrayList<Frag> getFrags(){
        return frags;        
    }
    
    public void setFrags(Frag frag){
        frags.add(frag);
    }
    
    public int getHeals(){
        return heals;
    }
    
    public void setHeals(int heal){
        heals = heals+heal;
    }
    
    public ArrayList<Damage> getDamage(){
        return damages;
    }
    
    public void setDamage(Damage damage){
        damages.add(damage);
        
    }
    
    public ArrayList<Assist> getAssists(){
        return assists;
    }
    
    public void setAssists(Assist assist){
        assists.add(assist);
    }
}
