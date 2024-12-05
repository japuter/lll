package Adapter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    // Constructor initializes the calendar instance
    public CalendarToNewDateAdapter() {
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Calendar months are 0-based, so subtract 1
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Calendar months are 0-based, so add 1
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_YEAR, days);
    }
}
