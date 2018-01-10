package edu.upi.retrofit.model;

/**
 * Created by Rizki on 12/20/2017.
 */

public class VolumeResponse {

    private VolumeInfo volumeInfo;

    public VolumeResponse(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
