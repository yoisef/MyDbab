package com.example.android.mydbab;

import com.example.android.mydbab.models.Example;
import com.example.android.mydbab.models.Examplecompleted;
import com.example.android.mydbab.models.ShopListExample;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface dbabapi  {

    @POST("activeOrders")
    Call<Example> getactiveorders(@Query("user_id") String usrid, @Query("user_type") String usertype , @Query("page") String mypage);

    @POST("finishedOrders")
    Call<Examplecompleted> getfinishedorders(@Query("user_id") String usrid, @Query("user_type") String usertype , @Query("page") String mypage);

    @POST("shopsList")
    Call<ShopListExample> getshoplist(@Query("destination_lat")String destinationlat,@Query("destination_long") String destinlong,@Query("page") String pageo);


}
