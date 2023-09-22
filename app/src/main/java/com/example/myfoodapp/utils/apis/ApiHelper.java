package com.example.myfoodapp.utils.apis;

import android.util.Log;

import com.example.myfoodapp.model.GetUserResponse;
import com.example.myfoodapp.model.ResponeObject;
import com.example.myfoodapp.model.ResponeSignUp;
import com.example.myfoodapp.utils.listener.StringCallback;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class ApiHelper {

    private ApiService api;
    private final String BASE_URL = "http://192.168.93.41/foodapp/";

    public ApiHelper() {
        if (api == null) {
            api = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
    }
    public void getListUser(StringCallback result) {
        api.getListUser().enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        String data = new Gson().toJson(response.body().getData());
                        result.execute(data);
                    } else result.execute("");
                } else result.execute("");
            }

            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) {
                result.execute("");
            }
        });
    }
    public void signUp( String email, String password,String userName,String phoneNumber,String address, StringCallback res) {
        if (api != null) {
            api.dangky( email, password,userName,phoneNumber,address).enqueue(new Callback<ResponeSignUp>() {
                @Override
                public void onResponse(Call<ResponeSignUp> call, Response<ResponeSignUp> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            res.execute(new Gson().toJson( response.body()) );
                            Log.d( "TAGa", "onResponse: 1" +response.body() );
                        } else {
                            res.execute("");
                            Log.d( "TAGa", "onResponse: 2" );
                        }
                    } else {
                        res.execute("");
                        Log.d( "TAGa", "onResponse: 3" );
                    }
                }

                @Override
                public void onFailure(Call<ResponeSignUp> call, Throwable t) {
                    res.execute("");
                }
            });
        }
    }
    public void UpdatePass( String id, String password,StringCallback res) {
        if (api != null) {
            api.updatePass( id, password).enqueue(new Callback<ResponeSignUp>() {
                @Override
                public void onResponse(Call<ResponeSignUp> call, Response<ResponeSignUp> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            res.execute(new Gson().toJson( response.body()) );

                        } else {
                            res.execute("");
                        }
                    } else {
                        res.execute("");
                    }
                }

                @Override
                public void onFailure(Call<ResponeSignUp> call, Throwable t) {
                    res.execute("");
                }
            });
        }
    }
    public  void SignIn(String email, String password, StringCallback res){
        if (api!=null){
            api.dangnhap( email,password ).enqueue( new Callback<GetUserResponse>() {
                @Override
                public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                    if (response.isSuccessful()){
                        if (response.body() != null) {
                            res.execute(new Gson().toJson( response.body()) );

                        } else {
                            res.execute("");
                        }
                    }else {
                        res.execute("");
                    }
                }

                @Override
                public void onFailure(Call<GetUserResponse> call, Throwable t) {
                    res.execute("");
                }
            } );
        }
    }



    private interface ApiService {
        @POST("getSignIn/functionGetUser.php")
        @FormUrlEncoded
        Call<GetUserResponse> dangnhap(
                @Field("username") String username,
                @Field("password") String password);

        @GET("getSignIn/readGetUser.php")
        Call<GetUserResponse> getListUser();


        @POST("dangky.php")
        @FormUrlEncoded
        Call<ResponeSignUp> dangky(
                @Field("email") String email,
                @Field("password") String password,
                @Field("userName") String userName,
                @Field("phoneNumber") String phoneNumber,
                @Field("address") String address
        );

        @POST("getUser/update_pass.php")
        @FormUrlEncoded
        Call<ResponeSignUp> updatePass(
                @Field("id") String id,
                @Field("password") String password

        );

    }

}
