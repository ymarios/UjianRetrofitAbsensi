package com.adl.ujianretrofitabsensi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("ujianloginabsen")
	val tabel: List<tableItem?>? = null
) : Parcelable

@Parcelize
data class tableItem(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable
