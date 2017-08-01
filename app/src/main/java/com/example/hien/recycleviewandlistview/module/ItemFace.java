package com.example.hien.recycleviewandlistview.module;

/**
 * Created by hien on 8/1/17.
 */

public class ItemFace {
    private int imageId;
    private String textFace;

    public ItemFace(int imageId, String textFace) {
        this.imageId = imageId;
        this.textFace = textFace;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTextFace() {
        return textFace;
    }

}
