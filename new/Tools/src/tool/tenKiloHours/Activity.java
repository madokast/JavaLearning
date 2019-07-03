package tool.tenKiloHours;

import java.lang.ref.SoftReference;
import java.util.Date;

public class Activity {
    private Date date;
    private String act;
    private int length;//minute

    private Activity() {
    }

    public Activity(String date, String act, String length) {
        //     * @param   year    the year minus 1900.
        //     * @param   month   the month between 0-11.
        //     * @param   date    the day of the month between 1-31.
        //     * @param   hrs     the hours between 0-23.
        //     * @param   min     the minutes between 0-59.
        //     * @param   sec     the seconds between 0-59.
        try {

            String[] dates = date.split("-");
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int day = Integer.parseInt(dates[2]);
//            System.out.println("day = " + day);
            this.date = new Date(year, month - 1, day);

            this.act = act;

            String[] lengths = length.split(":");
            int hour = Integer.parseInt(lengths[0]);
            int minutes = Integer.parseInt(lengths[1]);
            this.length = hour * 60 + minutes;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static Activity getInstance(String entry) {
        String[] entrys = entry.split(" ");
        String date = entrys[0];
        String act = entrys[1];
        String length = entrys[2];
        return new Activity(date, act, length);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return date.getYear() + "-" + (date.getMonth() + 1) + "-" +
                ((date.getDate()<10)?("0"+date.getDate()):(date.getDate())) + " " + String.format("%15s",act) + ((length<99)?" 0":" " +
                "") + length + "min";
    }

    public Date getDate() {
        return date;
    }

    public String getAct() {
        return act;
    }
}
