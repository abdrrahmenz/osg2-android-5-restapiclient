package osg.id.android_restapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MyModel {

    @Expose
    @SerializedName("body")
    public String body;
    @Expose
    @SerializedName("title")
    public String title;
    @Expose
    @SerializedName("id")
    public int id;
    @Expose
    @SerializedName("userId")
    public int userId;
}





