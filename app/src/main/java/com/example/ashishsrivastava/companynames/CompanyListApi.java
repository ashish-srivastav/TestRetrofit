package com.example.ashishsrivastava.companynames;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ashish.srivastava on 12/21/2015.
 */
public interface CompanyListApi {

    //@Get172.16.0.11:8084

    @GET("/GetCorporateList?Key=E60541290A0520121010")
    Call<Corporate> loadQuestions();

}
