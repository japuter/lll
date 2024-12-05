package Adapter;

// NewDateInterface.java
public interface NewDateInterface {
    void setDay(int day);
    void setMonth(int month); // 1 = January, 12 = December
    void setYear(int year);
    int getDay();
    int getMonth(); // Returns 1 = January, 12 = December
    int getYear();
    void advanceDays(int days);
}
