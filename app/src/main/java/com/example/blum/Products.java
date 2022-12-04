package com.example.blum;

public class Products {
    private Integer id;
    private Integer category;
    private String title;
    private String imageURL;
    private String articleNumber;
    private String distance;
    private String height;
    private String colour;
    private Integer articleID;
    private String fixingMethod;
    private String productURL;
    private Integer parentID;
    private String doorType;
    private String openingAngle;
    private String productSystem;
    private String cabinetHeight;
    private String cabinetMinDepth;
    private String powerFactorLF;

    public Products(){}


    public Products(Integer id, Integer articleID, String title, String imageURL, String articleNumber,
                    String distance, String height, String colour, Integer category, String fixingMethod,
                    String productURL, Integer parentID, String doorType, String openingAngle, String productSystem,
                    String cabinetHeight, String cabinetMinDepth, String powerFactorLF){
        this.id = id;
        this.category = category;
        this.articleID = articleID;
        this.title = title;
        this.imageURL = imageURL;
        this.articleNumber = articleNumber;
        this.distance = distance;
        this.height = height;
        this.colour = colour;
        this.fixingMethod = fixingMethod;
        this.productURL = productURL;
        this.parentID = parentID;
        this.doorType = doorType;
        this.openingAngle = openingAngle;
        this.productSystem = productSystem;
        this.cabinetHeight = cabinetHeight;
        this.cabinetMinDepth = cabinetMinDepth;
        this.powerFactorLF = powerFactorLF;
    }

    public String getCabinetHeight() {
        return cabinetHeight;
    }

    public void setCabinetHeight(String cabinetHeight) {
        this.cabinetHeight = cabinetHeight;
    }

    public String getCabinetMinDepth() {
        return cabinetMinDepth;
    }

    public void setCabinetMinDepth(String cabinetMinDepth) {
        this.cabinetMinDepth = cabinetMinDepth;
    }

    public String getPowerFactorLF() {
        return powerFactorLF;
    }

    public void setPowerFactorLF(String powerFactorLF) {
        this.powerFactorLF = powerFactorLF;
    }

    public String getDoorType() {
        return doorType;
    }

    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }

    public String getOpeningAngle() {
        return openingAngle;
    }

    public void setOpeningAngle(String openingAngle) {
        this.openingAngle = openingAngle;
    }

    public String getProductSystem() {
        return productSystem;
    }

    public void setProductSystem(String productSystem) {
        this.productSystem = productSystem;
    }

    public String getFixingMethod() {
        return fixingMethod;
    }

    public void setFixingMethod(String fixingMethod) {
        this.fixingMethod = fixingMethod;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
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

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getParentID() {
        return parentID;
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
