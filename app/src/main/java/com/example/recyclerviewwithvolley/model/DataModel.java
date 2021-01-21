package com.example.recyclerviewwithvolley.model;

public class DataModel {
    private String hedText;
    private String detailText;
    private String imgUrl;

    public DataModel() {

    }

    public DataModel(String hedText, String detailText, String imgUrl) {
        this.hedText = hedText;
        this.detailText = detailText;
        this.imgUrl = imgUrl;
    }

    //getter
    public String getHedText() {
        return hedText;
    }
    public String getDetailText() {
        return detailText;
    }
    public String getImgUrl() {
        return imgUrl;
    }
}
