package com.matrix87

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.matrix87.activities.Comment
import com.matrix87.activities.UserInfo
import com.matrix87.practicalapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTestActivity : AppCompatActivity() {

    val BASE_URL = "https://625d40ce95cd5855d61ddb5f.mockapi.io/users/all/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_test)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(MyServices::class.java)

        val user=UserInfo(
            createdAt = "121",
            name = "Elchin",
            avatar = "",
            id = 121323
        )

        retrofit.insertUser(user).cre(object : Callback<Use> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                Toast.makeText(
                    this@RetrofitTestActivity,
                    response.body()?.get(2)?.name ?: "epmty",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
             Log.d("MyTag",t.message.toString())
            }

        })

        GlobalScope.launch(Dispatchers.IO) {
            val comment = retrofit.getUsers().awaitResponse()

            if (comment.isSuccessful)
                Log.d("MyTag", comment.body()?.get(1)?.createdAt ?: "")

            val insert = retrofit.insertUser(

            )


        }

    }

}