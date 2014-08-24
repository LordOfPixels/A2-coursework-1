package a2.coursework.pkg1;
import java.util.Date;

public class Damage {
    String _victim;
    int _amount;
    Date _time;
    
    public Damage(String victim, int amount, Date time){
        _victim = victim;
        _amount = amount;
        _time = time;
    }
}
