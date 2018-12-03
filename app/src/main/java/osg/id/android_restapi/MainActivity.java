package osg.id.android_restapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import osg.id.android_restapi.adapter.MyAdapter;
import osg.id.android_restapi.model.MyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MyAdapter.onItemClickListener {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<MyModel> data = new ArrayList<>();
    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.myRec);
        initAdapter();
        showProgress();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MyModel>> call = apiInterface.getListUser();
        call.enqueue(new Callback<List<MyModel>>() {
            @Override
            public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                data.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<List<MyModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d("RESPONSE", "ERROR");
                t.printStackTrace();
            }
        });
    }

    private void showProgress() {
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("loading....");
        progressDoalog.setTitle("Harap Menunggu");
        progressDoalog.show();
    }

    private void initAdapter() {
        adapter = new MyAdapter(data, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick() {
        Intent intent = new Intent(this, DetailUserActivity.class);
        startActivity(intent);
    }
}
