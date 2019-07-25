package com.codemobiles.myfirebase.easyprepaid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var btn: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        // button
        topage2.setOnClickListener{
            startActivity(Intent(applicationContext, Menu::class.java))
=======

        tvresult = findViewById(R.id.tvresult) as TextView

        btn = findViewById(R.id.ScanQR) as ImageView

        btn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, ScanActivity::class.java)
            startActivity(intent)
>>>>>>> 0d648b6eff26a4053001b30dee6cb121359d44ee
        }

    }

    companion object {

        var tvresult: TextView? = null
    }
}
