package com.project_n.myapplication.Apis;

import com.project_n.myapplication.model.ModelData;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Created by amikom on 28/12/2018.
 */

public interface Interface {
    @GET("read.php")
    Call<List<ModelData>> getUser();

}
