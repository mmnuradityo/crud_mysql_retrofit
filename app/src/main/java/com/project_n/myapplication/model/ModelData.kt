package com.project_n.myapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Created by amikom on 21/12/2018.
 */

data class ModelData(
    @field:SerializedName("id_user")
    var id: String,

    @field:SerializedName("user_name")
    var nama: String,

    @field:SerializedName("user_email")
    var email: String,

    @field:SerializedName("user_password")
    var pass: String )
