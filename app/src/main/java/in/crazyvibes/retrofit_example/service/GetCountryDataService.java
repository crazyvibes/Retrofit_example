package in.crazyvibes.retrofit_example.service;



import in.crazyvibes.retrofit_example.model.Info;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Birju Kyumar.
 */
public interface GetCountryDataService {



      @GET("country/get/all")
      Call<Info> getResults();








}
