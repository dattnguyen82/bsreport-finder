package org.dtn82;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by 212391398 on 5/13/15.
 */
public class BSRInformation {

        @Id
        private String id;
        private String link;
        private String info;
        private Date date;
        private List<String> tokens;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public List<String> getTokens() {
            return tokens;
        }

        public void setTokens(List<String> tokens) {
            this.tokens = tokens;
        }

        @Override
        public String toString() {
            return "BSRInformation{" +
                    "id='" + id + '\'' +
                    ", link='" + link + '\'' +
                    ", info='" + info + '\'' +
                    ", date=" + date +
                    ", tokens=" + tokens +
                    '}';
        }

        public String toJson() {

            String json = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.writeValueAsString(this);
                return json;
            }
            catch (Exception e)
            {
                System.err.println("Object type is not mappable to json\n" + e.getMessage() );
            }
            return json;
        }

    //
//    "link": "http://c.espnradio.com/audio/2436316/bsreport_2015-02-14-163716.64k.mp3",
//            "date": "2015-02-14",
//            "info": "Bill Simmons Zach Lowe and Marc Stein look at the league as we head into the trade deadline",
//            "tokens": [
//            "Bill",
//            "Simmons",
//            "Zach",
//            "Lowe",
//            "and",
//            "Marc",
//            "Stein",
//            "look",
//            "at",
//            "the",
//            "league",
//            "as",
//            "we",
//            "head",
//            "into",
//            "the",
//            "trade",
//            "deadline"
//            ]


}
