package com.example.edwardlucci.edwardzhihupaper.bean;

import android.content.ContentValues;
import android.view.SoundEffectConstants;

import com.example.edwardlucci.edwardzhihupaper.database.StoryDatabaseContract;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Story implements Serializable{

    @SerializedName("images")
    @Expose
    private List<String> images = new ArrayList<String>();
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public ContentValues story2contentvalues(String date){
        ContentValues contentValues = new ContentValues();
        contentValues.put(StoryDatabaseContract.StoryTable.COLUMN_NAME_DATE,date);
        contentValues.put(StoryDatabaseContract.StoryTable.COLUMN_NAME_ID,this.id);
        contentValues.put(StoryDatabaseContract.StoryTable.COLUMN_NAME_IMAGES, String.valueOf(this.getImages()));
        contentValues.put(StoryDatabaseContract.StoryTable.COLUMN_NAME_TITLE,this.title);
        return contentValues;
    }
}
