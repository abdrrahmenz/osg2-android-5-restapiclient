package osg.id.android_restapi;

import java.util.List;

import osg.id.android_restapi.model.MyModel;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/users")
    Call<List<MyModel>> getListUser();

    @GET("/users/1")
    Call<MyModel> getDetailUser();

}



