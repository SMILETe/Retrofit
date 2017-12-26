package com.smile.retrofit.networking;

import com.smile.retrofit.CustomModel;
import com.smile.retrofit.Movie;
import com.smile.retrofit.postserver.postmodel.PostServer;
import com.smile.retrofit.postserver.postmodel.ResponseFromServer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by atechnos pc on 12/2/2017.
 */

public interface AtechnosServerService {
    @GET("cms/news_api/api/get_news.php")
    Call<Movie> getNews(@Query("lan") String language, @Query("cat") String cat);
// ist method using json
    @POST("safari/api/placebook.php")
    Call<ResponseFromServer>  postServer(@Body PostServer postServer);

  // 2nd method using formdata
    @FormUrlEncoded
    @POST("safari/api/placebook.php")
    Call<ResponseFromServer>  postServerwithparameter(@Field("name") String name,@Field("email") String email);
//    @GET("weather")
//    Call<Object> currentWeather(@Query("q") String cityName, @Query("appid") String apiKey);
  //  http://atechnos.net/cms/news_api/api/get_news.php?lan=null&cat=Topstories
   // http://atechnos.net/safari/api/placebook.php
}
