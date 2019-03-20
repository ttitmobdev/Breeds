package com.example.user.breeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private Api api;
    BreedsAdapter adapter;
    List<BreedResponse> breedResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        breedResponses = new ArrayList<>();
        recyclerView = findViewById(R.id.recView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BreedsAdapter(breedResponses);
        recyclerView.setAdapter(adapter);

        api = ApiUtils.getApiService();
        loadBreeds();

    }
    public void loadBreeds(){
        Call<BreedResponse> call = api.getBreeds();
        call.enqueue(new Callback<BreedResponse>() {
            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"NORM",Toast.LENGTH_SHORT).show();
                    breedResponses.add(response.body());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
                else
                    Log.e("BREED", "response"+response.body());
                    Toast.makeText(getApplicationContext(),"FAil",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {
                Log.e("BREEED","ASD"+t.toString());
                Toast.makeText(getApplicationContext(),"wtf",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
