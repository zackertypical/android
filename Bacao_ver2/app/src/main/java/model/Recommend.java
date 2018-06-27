package model;

/**
 * Created by zackerzhuang on 2018/6/12.
 */

public class Recommend {
    private String name;
    private int imageId;
    public Recommend(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
