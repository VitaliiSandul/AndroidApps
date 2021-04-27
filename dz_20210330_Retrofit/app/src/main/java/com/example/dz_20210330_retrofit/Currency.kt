package com.example.dz_20210330_retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("ccy")
    @Expose
    var ccy: String,
    @SerializedName("base_ccy")
    @Expose
    var base_ccy: String,
    @SerializedName("buy")
    @Expose
    var buy: String,
    @SerializedName("sale")
    @Expose
    var sale: String
)