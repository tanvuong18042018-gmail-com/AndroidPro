package com.nhphuc.doen;

public class Credit {
    private int idCredit;
    private String nameCredit;
    private int priceCredit;

    public Credit(int idCredit, String nameCredit, int priceCredit) {
        this.setIdCredit(idCredit);
        this.setNameCredit(nameCredit);
        this.setPriceCredit(priceCredit);
    }


    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public String getNameCredit() {
        return nameCredit;
    }

    public void setNameCredit(String nameCredit) {
        this.nameCredit = nameCredit;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }
}
