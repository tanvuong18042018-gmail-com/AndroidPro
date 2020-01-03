package com.nhphuc.doen;

public class Login {
    private int id;
    private String name_login;
    private String email;
    private String password;
    private String avatar;
    private int max_score;
    private int credit;
    private int diamon;

    public Login(int id, String name_login, String email, String password, String avatar, int max_score, int credit, int diamon) {
        this.setId(id);
        this.setName_login(name_login);
        this.setEmail(email);
        this.setPassword(password);
        this.setAvatar(avatar);
        this.setMax_score(max_score);
        this.setCredit(credit);
        this.setDiamon(diamon);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_login() {
        return name_login;
    }

    public void setName_login(String name_login) {
        this.name_login = name_login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getMax_score() {
        return max_score;
    }

    public void setMax_score(int max_score) {
        this.max_score = max_score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDiamon() {
        return diamon;
    }

    public void setDiamon(int diamon) {
        this.diamon = diamon;
    }
}
