package edu.upi.retrofit.rest;

import java.util.List;

import edu.upi.retrofit.model.Accounts;
import edu.upi.retrofit.model.VolumeResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Rizki on 12/20/2017.
 */

public interface ApiInterface {

    @GET("accounts")
    Call<List<Accounts>> getUserLogin(@Query("username") String username, @Query("password") String password);

    @FormUrlEncoded
    @POST("accounts")
    Call<Accounts> postAccount(@Field("username") String username, @Field("password") String password, @Field("email") String email);

    @FormUrlEncoded
    @PUT("accounts")
    Call<Accounts> putAccount(@Field("username") String username,
                              @Field("password") String password,
                              @Field("email") String email);

}
