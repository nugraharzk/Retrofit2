package edu.upi.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.upi.retrofit.model.Accounts;
import edu.upi.retrofit.model.VolumeInfo;
import edu.upi.retrofit.model.VolumeResponse;
import edu.upi.retrofit.rest.ApiClient;
import edu.upi.retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.title);
        final TextView desc = findViewById(R.id.desc);

        final EditText etUname = findViewById(R.id.uname);
        final EditText etPass = findViewById(R.id.pass);
        Button btn = findViewById(R.id.btn);

        String username = etUname.getText().toString().trim();
        String password = etPass.getText().toString().trim();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Call<Accounts> call = apiInterface.postAccount(username, password, "Cek Rizal");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.enqueue(new Callback<Accounts>() {
                    @Override
                    public void onResponse(Call<Accounts> call, Response<Accounts> response) {
                        Log.d("ResponseBody", "onResponse: " + response.body());
                    }

                    @Override
                    public void onFailure(Call<Accounts> call, Throwable t) {
                        Log.d("Hasil Retrofit", "onFailure: " + t);
                    }
                });
                Toast.makeText(getBaseContext(), "Akun ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
