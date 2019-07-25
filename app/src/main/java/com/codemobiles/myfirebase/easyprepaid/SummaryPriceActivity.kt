package com.codemobiles.myfirebase.easyprepaid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codemobiles.myfirebase.easyprepaid.beans.TokenBody
import com.codemobiles.myfirebase.easyprepaid.beans.TokenResponse
import com.codemobiles.myfirebase.easyprepaid.model.ScbHttpClient
import com.codemobiles.myfirebase.hackatonpractice.DeeplinkBody
import com.codemobiles.myfirebase.hackatonpractice.DeeplinkPaymentResponse
import kotlinx.android.synthetic.main.activity_summary_price.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class SummaryPriceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_price)

        paymentButton.setOnClickListener {
            Log.i("hackaton", "click to pay")
            getTokenFromApi()
        }

    }

    private fun getTokenFromApi(){
        TokenBody(
            "l78556f5872aa2458d91b54c2e8fb006f0",
            "4858a95fd5304ecbb817af12773c90cb"
        ).apply {
            val cal = ScbHttpClient.create().getAccessToken(this)
            cal.enqueue(object : Callback<TokenResponse> {
                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    try {
                        Log.i("hackaton", response.body().toString())
                        Log.i("hackaton", response.body()!!.data.accessToken)
                        val accessToken = response.body()!!.data.accessToken
                        getDeeplink(accessToken)

                    } catch (e: Throwable){
                        Log.i("hackaton", e.message.toString())
                    }
                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    Log.i("hackaton", t.message.toString())
                }
            })
        }
    }

private fun getDeeplink(auth: String){
    DeeplinkBody("245064434545984",
        100.00,"REFERENCE1","REFERENCE2","REFERENCE3","BPA","PAYMENT").apply {
        val cal = ScbHttpClient.create().getDeeplink(
            "Bearer $auth",
            this
        )
        cal.enqueue(object : Callback<DeeplinkPaymentResponse> {
            override fun onResponse(call: Call<DeeplinkPaymentResponse>, response: Response<DeeplinkPaymentResponse>) {
                try {
                    Log.i("hackaton", response.body()!!.data.toString())
                    val url = response.body()!!.data.deeplinkUrl
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(browserIntent)

                } catch (e: IOException){
                    Log.i("hackaton", e.message.toString())
                }
            }

            override fun onFailure(call: Call<DeeplinkPaymentResponse>, t: Throwable) {
                Log.i("hackaton", t.message.toString())
            }
        })
    }
}
}
