package in.crazyvibes.retrofit_example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 Created by Birju Kumar. */
public class Info {

    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
