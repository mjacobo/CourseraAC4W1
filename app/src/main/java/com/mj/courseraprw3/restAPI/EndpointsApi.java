package com.mj.courseraprw3.restAPI;

import com.mj.courseraprw3.restAPI.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by leyenda1 on 16/10/2016.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_GET_MY_INFO)
    Call<PetResponse> getMyInfo();

    @GET(ConstantesRestApi.URL_GET_LIST_USER_FOLLOWS)
    Call<PetResponse> getMyFriendList();

    @GET
    Call<PetResponse> getMyFriendInfo(@Url String url);

    @GET
    Call<PetResponse> getFriendRecentMedia(@Url String url);

}
