package osg.id.android_restapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import osg.id.android_restapi.model.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_user);


    }
}