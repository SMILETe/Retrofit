package com.smile.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smile.retrofit.networking.AtechnosServerService;
import com.smile.retrofit.networking.RetrofitRestController;
import com.smile.retrofit.postserver.postmodel.PostServer;
import com.smile.retrofit.postserver.postmodel.ResponseFromServer;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ListView listView;
    Button send,sendform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list) ;
        send= (Button) findViewById(R.id.send);
        sendform= (Button) findViewById(R.id.sendform);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postdata();
            }
        });
        sendform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postdatawithform();
            }
        });
        fetchnews();
    }

    private void postdatawithform() {
        PostServer postServer= new PostServer();

        postServer.setEmail("heena@gmail.com");
        postServer.setName("heenaone");
        AtechnosServerService Service = RetrofitRestController.getClient().create(AtechnosServerService.class);
        Call<ResponseFromServer> call = Service.postServerwithparameter(postServer.getName(),postServer.getEmail());
        // TODO: 01/12/17 Below mentioned code is for aSynchronus call
        call.enqueue(new Callback<ResponseFromServer>() {
            @Override
            public void onResponse(Call<ResponseFromServer> call, Response<ResponseFromServer> response) {
                String respons=response.body().getMsg();
                Toast.makeText(MainActivity.this,respons,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseFromServer> call, Throwable t) {

            }
        });
    }

    private void postdata() {
        PostServer postServer= new PostServer();
        postServer.setContact("heena");
        postServer.setEmail("heena@gmail.com");
        postServer.setName("heenaone");
        postServer.setQuery("good");

        AtechnosServerService Service = RetrofitRestController.getClient().create(AtechnosServerService.class);
        Call<ResponseFromServer> call = Service.postServer(postServer);
        // TODO: 01/12/17 Below mentioned code is for aSynchronus call
       call.enqueue(new Callback<ResponseFromServer>() {
           @Override
           public void onResponse(Call<ResponseFromServer> call, Response<ResponseFromServer> response) {
               String respons=response.body().getMsg();
               Toast.makeText(MainActivity.this,respons,Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(Call<ResponseFromServer> call, Throwable t) {

           }
       });
    }

    private void fetchnews() {
        Log.d(TAG, "onResponse: " + "inside fetch");
        AtechnosServerService Service = RetrofitRestController.getClient().create(AtechnosServerService.class);
        Call<Movie> call = Service.getNews("null", "Sports");
        // TODO: 01/12/17 Below mentioned code is for aSynchronus call
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                Log.d(TAG, "oncatogoty: " + response.body().getBanner().get(2).getCategory());

                CustomAdator customAdapter= new CustomAdator(MainActivity.this,response.body().getBanner() );
                listView.setAdapter(customAdapter);
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
            }
        });
    }
}
