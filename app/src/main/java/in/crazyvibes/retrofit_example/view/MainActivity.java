package in.crazyvibes.retrofit_example.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import in.crazyvibes.retrofit_example.R;
import in.crazyvibes.retrofit_example.adapter.CountryAdapter;
import in.crazyvibes.retrofit_example.model.Info;
import in.crazyvibes.retrofit_example.model.Result;
import in.crazyvibes.retrofit_example.service.GetCountryDataService;
import in.crazyvibes.retrofit_example.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCountries();
    }

    public Object getCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Info> call = getCountryDataService.getResults();

        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {

                Info info = response.body();

                if (info != null && info.getRestResponse() != null) {

                    results = (ArrayList<Result>) info.getRestResponse().getResult();

//                    for (Result r : results) {
//
//                        Log.i("testing123", "*********************************" + r.getName());
//
//                    }


                    viewData();


                }

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.i("testing123", "failed");
            }
        });


        return results;
    }

    private void viewData() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_countries_list);
        countryAdapter = new CountryAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);


    }
}
