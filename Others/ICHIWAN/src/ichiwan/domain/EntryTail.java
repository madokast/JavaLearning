package ichiwan.domain;

/**
 * 带有推进型统计值的Entry
 *
 *     id int primary key auto_increment,
 *     dateDone date not null ,
 *     name varchar(20) not null ,
 *     lengthMinute int not null ,
 *     describing varchar(100),
 *
 *     relativeDate int,
 *     totalMinute int,
 *     averageMinute double
 */

public class EntryTail extends Entry{
    private static final int HOUR_MINUTE = 60;
    private static final int MaximumFractionDigits = 3;
    private int relativeDate;
    private int totalMinute;
    private double averageMinute;

    /**
     * 视图属性
     * @return
     */
    public String getTotalHourMinute(){
        return totalMinute/HOUR_MINUTE + "H" + (totalMinute - totalMinute/HOUR_MINUTE*HOUR_MINUTE) + "M";
    }

    public int getRelativeDate() {
        return relativeDate;
    }

    public void setRelativeDate(int relativeDate) {
        this.relativeDate = relativeDate;
    }

    public int getTotalMinute() {
        return totalMinute;
    }

    public void setTotalMinute(int totalMinute) {
        this.totalMinute = totalMinute;
    }

    public double getAverageMinute() {
        double temp = Math.pow(10.0,MaximumFractionDigits);
        return Math.round(averageMinute*temp)/temp;
    }

    public void setAverageMinute(double averageMinute) {
        this.averageMinute = averageMinute;
    }

    @Override
    public String toString() {
        return "EntryTail{" + super.toString() +
                "relativeDate=" + relativeDate +
                ", totalMinute=" + totalMinute +
                ", averageMinute=" + averageMinute +
                '}';
    }
}
