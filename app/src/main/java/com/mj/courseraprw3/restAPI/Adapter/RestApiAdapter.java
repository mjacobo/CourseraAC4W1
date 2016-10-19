package com.mj.courseraprw3.restAPI.Adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mj.courseraprw3.restAPI.ConstantesRestApi;
import com.mj.courseraprw3.restAPI.EndpointsApi;
import com.mj.courseraprw3.restAPI.deserializador.AccountDeserealizador;
import com.mj.courseraprw3.restAPI.deserializador.PetDeserealizador;
import com.mj.courseraprw3.restAPI.model.PetResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leyenda on 10/17/16.
 */

public class RestApiAdapter {
    public EndpointsApi stablishConnectionApiInstagram(Gson gson){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(ConstantesRestApi.ROOT_URL)
               .addConverterFactory(GsonConverterFactory.create(gson))
               .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson buildGsonDeserializerMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserealizador());

        return  gsonBuilder.create();
    }

    public Gson buildGsonDeserializerAccount(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new AccountDeserealizador());

        return  gsonBuilder.create();
    }
}
