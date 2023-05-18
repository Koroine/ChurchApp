package com.elon.kmlkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ContributionActivity : AppCompatActivity() {
    lateinit var Btnmpesa:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contribution)
        Btnmpesa=findViewById(R.id.Btn_Mpesa)

        Btnmpesa.setOnClickListener {
            val simToolkitLauncherIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolkitLauncherIntent?.let { startActivity(it) }
        }
    }
}




















