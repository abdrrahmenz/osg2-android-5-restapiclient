package osg.id.android_restapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class MyModel2 {

    @SerializedName("data")
    private List<MyModel> data;

}

