package ichiwan.domain;

/**
 * Entry 的表单形式
 * 至少在servlet里生成EntryForm对象时，不会抛出任何异常
 * 在DAO类中，再处理可能的异常，如负数、空等
 */

//    private int id;
//    private Date dateDone;
//    private String name;
//    private int lengthMinute;
//    private String describing;

public class EntryForm {
    private String id;
    private String dateDone;
    private String name;
    private String lengthMinute;
    private String describing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateDone() {
        return dateDone;
    }

    public void setDateDone(String dateDone) {
        this.dateDone = dateDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLengthMinute() {
        return lengthMinute;
    }

    public void setLengthMinute(String lengthMinute) {
        this.lengthMinute = lengthMinute;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing;
    }

    @Override
    public String toString() {
        return "EntryForm{" +
                "id='" + id + '\'' +
                ", dateDone='" + dateDone + '\'' +
                ", name='" + name + '\'' +
                ", lengthMinute='" + lengthMinute + '\'' +
                ", describing='" + describing + '\'' +
                '}';
    }
}
