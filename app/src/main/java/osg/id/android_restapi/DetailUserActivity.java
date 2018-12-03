package osg.id.android_restapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import osg.id.android_restapi.model.MyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserActivity extends AppCompatActivity {

    private TextView txtName, txtUsername, txtEmail, txtStreet, txtSuite, txtCity, txtZipCode, txtPhone, txtWebsite;
    private TextView txtCompanyName, txtCatchPhrase, txtBs;
    private ApiInterface apiInterface;
    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_user);

        txtName = (TextView) findViewById(R.id.detail_name);
        txtUsername = (TextView) findViewById(R.id.detail_user_name);
        txtEmail = (TextView) findViewById(R.id.detail_email);
        txtStreet = (TextView) findViewById(R.id.detail_street);
        txtSuite = (TextView) findViewById(R.id.detail_suite);
        txtCity = (TextView) findViewById(R.id.detail_city);
        txtZipCode = (TextView) findViewById(R.id.detail_zipcode);
        txtPhone = (TextView) findViewById(R.id.detail_phone);
        txtWebsite = (TextView) findViewById(R.id.detail_website);
        txtCompanyName = (TextView) findViewById(R.id.detail_companyName);
        txtCatchPhrase = (TextView) findViewById(R.id.detail_chatPharase);
        txtBs = (TextView) findViewById(R.id.detail_bs);

        //show progress
        showProgress();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MyModel> call = apiInterface.getDetailUser();
        call.enqueue(new Callback<MyModel>() {
            @Override
            public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                progressDoalog.dismiss();
                setValue(response.body());

            }

            @Override
            public void onFailure(Call<MyModel> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(DetailUserActivity.this, "Error Get Data Detail", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }


    private void setValue(MyModel data) {
        txtName.setText(data.name);
        txtUsername.setText(data.username);
        txtEmail.setText(data.email);
        txtStreet.setText(data.address.street);
        txtSuite.setText(data.address.suite);
        txtCity.setText(data.address.city);
        txtZipCode.setText(data.address.zipcode);
        txtPhone.setText(data.phone);
        txtWebsite.setText(data.website);
        txtCompanyName.setText(data.company.name);
        txtCatchPhrase.setText(data.company.catchPhrase);
        txtBs.setText(data.company.bs);

    }


    private void showProgress() {
        progressDoalog = new ProgressDialog(DetailUserActivity.this);
        progressDoalog.setMessage("loading....");
        progressDoalog.setTitle("Harap Menunggu");
        progressDoalog.show();
    }

}
