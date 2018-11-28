package osg.id.android_restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import osg.id.android_restapi.model.MyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.myText);



        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MyModel> call = apiInterface.mengambilDataPost();
        call.enqueue(new Callback<MyModel>() {
            @Override
            public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                MyModel data = response.body();
                myText.setText(data.title);
            }

            @Override
            public void onFailure(Call<MyModel> call, Throwable t) {
                        t.printStackTrace();
            }
        });
    }
}
