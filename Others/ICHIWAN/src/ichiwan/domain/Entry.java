package ichiwan.domain;

import java.sql.Date;

/**
 * javaBean
 * <td>编号</td>
 * <td>时间</td>
 * <td>项目</td>
 * <td>说明</td>
 *
 *     id int primary key auto_increment,
 *     dateDone date not null ,
 *     name varchar(20) not null ,
 *     lengthMinute int,
 *     describing varchar(100)
 */

public class Entry {
    private int id;
    private Date dateDone;
    private String name;
    private int lengthMinute;
    private String describing;

    public int getLengthMinute() {
        return lengthMinute;
    }

    public void setLengthMinute(int lengthMinute) {
        this.lengthMinute = lengthMinute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDone(Date dateDone) {
        this.dateDone = dateDone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    public int getId() {
        return id;
    }

    public Date getDateDone() {
        return dateDone;
    }

    public String getName() {
        return name;
    }

    public String getDescribing() {
        return describing;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", dateDone=" + dateDone +
                ", name='" + name + '\'' +
                ", lengthMinute=" + lengthMinute +
                ", describing='" + describing + '\'' +
                '}';
    }

    public String toStringInsert(){
        //INSERT INTO entries(id,dateDone,name,lengthMinute,describing) VALUES (1,'2019-08-22','java',36,NULL);
        return "INSERT INTO entries(dateDone,name,lengthMinute,describing) VALUES ('"+dateDone
                +"','"+name
                +"',"+
                lengthMinute+","+describing
                +");";

    }
}
