package com.nhphuc.doen;

public class Question {
    private int id;
    private String cont_question;
    private String result_a;
    private String result_b;
    private String result_c;
    private String result_d;
    private String result;
    private String field;

    public Question(int id, String cont_question, String result_a, String result_b, String result_c, String result_d, String result, String field) {
        this.setId(id);
        this.setCont_question(cont_question);
        this.setResult_a(result_a);
        this.setResult_b(result_b);
        this.setResult_c(result_c);
        this.setResult_d(result_d);
        this.setResult(result);
        this.setField(field);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCont_question() {
        return cont_question;
    }

    public void setCont_question(String cont_question) {
        this.cont_question = cont_question;
    }

    public String getResult_a() {
        return result_a;
    }

    public void setResult_a(String result_a) {
        this.result_a = result_a;
    }

    public String getResult_b() {
        return result_b;
    }

    public void setResult_b(String result_b) {
        this.result_b = result_b;
    }

    public String getResult_c() {
        return result_c;
    }

    public void setResult_c(String result_c) {
        this.result_c = result_c;
    }

    public String getResult_d() {
        return result_d;
    }

    public void setResult_d(String result_d) {
        this.result_d = result_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
