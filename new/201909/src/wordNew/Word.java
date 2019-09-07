package wordNew;

public class Word {
    private String time;
    private String body;


    @Override
    public String toString() {
        return "Word{" +
                "time='" + time + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
