package ir.sbu.softwareengineering_proposal.api

import androidx.lifecycle.LiveData
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(@Field("national_number") nationalNumber: String,
                @Field("password") password: String)


}