package com.nhphuc.doen;

public class Rank {

    private String numberOrderRank;
    private int imageRank;
    private String nameRank;
    private String scoreRank;



    public Rank(String numberOrderRank, int imageRank, String nameRank, String scoreRank) {
        this.setNumberOrderRank(numberOrderRank);
        this.setImageRank(imageRank);
        this.setNameRank(nameRank);
        this.setScoreRank(scoreRank);
    }

    public String getNumberOrderRank() {
        return numberOrderRank;
    }

    public void setNumberOrderRank(String numberOrderRank) {
        this.numberOrderRank = numberOrderRank;
    }

    public int getImageRank() {
        return imageRank;
    }

    public void setImageRank(int imageRank) {
        this.imageRank = imageRank;
    }

    public String getNameRank() {
        return nameRank;
    }

    public void setNameRank(String nameRank) {
        this.nameRank = nameRank;
    }

    public String getScoreRank() {
        return scoreRank;
    }

    public void setScoreRank(String scoreRank) {
        this.scoreRank = scoreRank;
    }
}
