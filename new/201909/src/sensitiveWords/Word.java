package sensitiveWords;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Word {
    public Date date;
    public String time;
    public String body;

    @Override
    public String toString() {
        return "Word{" +
                "date=" + date +
                ", body='" + body + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Word() {
    }

    public Word(Date date, String body) {
        this.date = date;
        this.body = body;
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
