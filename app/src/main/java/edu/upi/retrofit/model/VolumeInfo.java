package edu.upi.retrofit.model;

/**
 * Created by Rizki on 12/20/2017.
 */

public class VolumeInfo {
    private String title, description;

    public VolumeInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = description;
    }
}
