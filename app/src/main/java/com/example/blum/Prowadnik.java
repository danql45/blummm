package com.example.blum;

public class Prowadnik {
    private Integer id;
    private Integer category;
    private String title;
    private String imageURL;
    private String articleNumber;
    private String distance;
    private String height;
    private String colour;
    private Integer articleID;

    public Prowadnik(){}


    public Prowadnik(Integer id, Integer articleID, String title, String imageURL, String articleNumber, String distance, String height, String colour, Integer category){
        this.id = id;
        this.category = category;
        this.articleID = articleID;
        this.title = title;
        this.imageURL = imageURL;
        this.articleNumber = articleNumber;
        this.distance = distance;
        this.height = height;
        this.colour = colour;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
