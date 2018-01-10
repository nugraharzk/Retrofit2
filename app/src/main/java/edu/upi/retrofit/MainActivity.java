package edu.upi.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import edu.upi.retrofit.model.VolumeInfo;
import edu.upi.retrofit.model.VolumeResponse;
import edu.upi.retrofit.rest.ApiClient;
import edu.upi.retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private VolumeResponse volumeResponse;
    private VolumeInfo volumeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.title);
        final TextView desc = findViewById(R.id.desc);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<VolumeResponse> call = apiInterface.getVolumeInfo();

        call.enqueue(new Callback<VolumeResponse>() {
            @Override
            public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {
                volumeResponse = response.body();
                volumeInfo = volumeResponse.getVolumeInfo();
                textView.setText(volumeInfo.getTitle());
                desc.setText(volumeInfo.getDescription());

                Log.d("ResponseBody", "onResponse: " + volumeResponse.getVolumeInfo().getTitle());
            }

            @Override
            public void onFailure(Call<VolumeResponse> call, Throwable t) {
                Log.d("Hasil Retrofit", "onFailure: ");
            }
        });
    }
}
