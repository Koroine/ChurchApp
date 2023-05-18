package com.elon.kmlkapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewsActivity2 : AppCompatActivity() {
    lateinit var Buttoncontribute:Button
    lateinit var Buttonactivities:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news2)

        Buttoncontribute=findViewById(R.id.btn_cont)
        Buttoncontribute.setOnClickListener {
            val intent=Intent(this,ContributionActivity::class.java)
            startActivity(intent)
        }
        Buttonactivities=findViewById(R.id.Btn_acti)
        Buttonactivities.setOnClickListener {
            val intent=Intent(this,FunctionsActivity::class.java)
            startActivity(intent)
        }

    }
}