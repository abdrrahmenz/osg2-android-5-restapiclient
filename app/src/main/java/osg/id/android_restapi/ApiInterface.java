package osg.id.android_restapi;

import osg.id.android_restapi.model.MyModel;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/posts/1")
    Call<MyModel> mengambilDataPost();


}



