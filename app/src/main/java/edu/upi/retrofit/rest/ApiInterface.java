package edu.upi.retrofit.rest;

import edu.upi.retrofit.model.VolumeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rizki on 12/20/2017.
 */

public interface ApiInterface {

    @GET("v1/volumes/yZ1APgAACAAJ")
    Call<VolumeResponse> getVolumeInfo();

}
