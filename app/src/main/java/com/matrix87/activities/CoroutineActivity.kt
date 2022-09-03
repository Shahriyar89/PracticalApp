package com.matrix87.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.matrix87.practicalapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

val BASEURL = "https://jsonplaceholder.typicode.com"

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)


        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Services::class.java)

//        retrofit.getComments().enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                Log.d("MyTagg", response.body()?.get(2)?.email ?: "empty")
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })

        GlobalScope.launch(Dispatchers.IO) {
            val response = retrofit.getComments().awaitResponse()
            if (response.isSuccessful) {
                Log.d("MyTagg", response.body()?.get(3)?.email?:"")
            }

        }
    }
}