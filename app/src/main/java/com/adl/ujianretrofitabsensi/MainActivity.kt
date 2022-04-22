package com.adl.ujianretrofitabsensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.ujianretrofitabsensi.model.UserResponse
import com.adl.ujianretrofitabsensi.service.IUser
import com.adl.ujianretrofitabsensi.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener({
            login()
        })
    }

    fun login(){
        RetrofitConfig().getRetro().login(et_username.text.toString()).enqueue(object: Callback<UserResponse>{
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                var data = response.body()?.data?.tabel

                if(response.isSuccessful){
                    Log.d("data","${data}")
                    if (data?.size == 0){
                        Toast.makeText(this@MainActivity,"Masukkan Username dan Password", Toast.LENGTH_LONG).show()
                    }else{

                        var getuser = response.body()?.data?.tabel?.get(0)
                        if(getuser?.password == et_password.text.toString()){
                            Toast.makeText(this@MainActivity,"Login Berhasil", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@MainActivity, MainMenu::class.java)
                            intent.putExtra("data", getuser)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@MainActivity,"Password Salah", Toast.LENGTH_LONG).show()
                        }

                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }

        })
    }
}