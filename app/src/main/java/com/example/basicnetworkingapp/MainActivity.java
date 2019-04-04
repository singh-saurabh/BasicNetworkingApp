package com.example.basicnetworkingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private static final String APIKEY="31556774";
private InterfaceAPI service;
private TextView textView;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMovie();
            }
        });
        service= BuilderAPI.getClient().create(InterfaceAPI.class);
    }

    void getMovie(){
        service.getMovie(APIKEY, "Fast and Furious").enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                assert response.body() != null;
                textView.setText(response.body().getPlot());
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
