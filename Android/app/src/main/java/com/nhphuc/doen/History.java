package com.nhphuc.doen;

public class History {
    private String Day;
    private String NumberOrder;
    private String Score;

    public History(String numberOrder, String score, String day) {
        setNumberOrder(numberOrder);
        setDay(day);
        setScore(score);
    }


    public String getNumberOrder() {
        return NumberOrder;
    }

    public void setNumberOrder(String numberOrder) {
        NumberOrder = numberOrder;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}
