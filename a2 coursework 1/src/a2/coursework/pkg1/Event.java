package a2.coursework.pkg1;

import java.util.Date;

public class Event{
        private Date date;
        private String name;
        private String steamId;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getSteamId() {
            return steamId;
        }
        
        public void setSteamId(String steamId) {
            this.steamId = steamId;
        }
    }
