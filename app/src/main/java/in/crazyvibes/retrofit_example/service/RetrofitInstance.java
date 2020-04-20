package in.crazyvibes.retrofit_example.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Birju Kumar.
 */
public class RetrofitInstance {


    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://groupkt.com/";

    public static GetCountryDataService getService() {


        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit.create(GetCountryDataService.class);
    }


}
