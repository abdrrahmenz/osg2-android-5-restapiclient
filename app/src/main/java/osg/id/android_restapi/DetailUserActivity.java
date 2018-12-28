package osg.id.android_restapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import osg.id.android_restapi.model.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private TextView textName, textUsername, textEmail, textCity, textPhone, textWebsite;
    private Users users = new Users();
    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_user);
        initViews();
        showProgress();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Users> call = apiInterface.getUser(getIntent().getIntExtra("id_users",-1));
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                users = response.body();
                textName.setText(String.format("Nama : %s", users.name));
                textUsername.setText(String.format("Username : %s", users.username));
                textEmail.setText(String.format("Email : %s", users.email));
                textWebsite.setText(String.format("Website : %s", users.website));
                textPhone.setText(String.format("Phone : %s", users.phone));
                textCity.setText(String.format("City : %s", users.address.city));
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d("RESPONSE", "ERROR");
                t.printStackTrace();
            }
        });
    }

    private void initViews(){
        textName = findViewById(R.id.text_name);
        textUsername = findViewById(R.id.text_username);
        textEmail = findViewById(R.id.text_email);
        textWebsite = findViewById(R.id.text_website);
        textCity = findViewById(R.id.text_city);
        textPhone = findViewById(R.id.text_phone);
        getSupportActionBar().setTitle("Detail User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showProgress() {
        progressDoalog = new ProgressDialog(DetailUserActivity.this);
        progressDoalog.setMessage("loading....");
        progressDoalog.setTitle("Harap Menunggu");
        progressDoalog.show();
    }
}