package com.example.foodcalender.Domain;

public class Food {

    private String Title;
    private String BakingTime;
    private String Material;
    private String Recipe;
    private int Thumbnail ;

    public Food() {
    }

    public Food(String title, String bakingTime, String material, String recipe, int thumbnail) {
        Title = title;
        BakingTime = bakingTime;
        Material = material;
        Recipe = recipe;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getBakingTime() {
        return BakingTime;
    }

    public String getMaterial() {
        return Material;
    }

    public String getRecipe() {
        return Recipe;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setBakingTime(String bakingTime) {
        BakingTime = bakingTime;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
