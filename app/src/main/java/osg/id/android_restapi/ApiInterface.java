package osg.id.android_restapi;

import java.util.List;

import osg.id.android_restapi.model.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users")
    Call<List<Users>> getListUser();

    @GET("/users/{id}")
    Call<Users> getUser(@Path("id") Integer id);

}



