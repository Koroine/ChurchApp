package com.elon.kmlkapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class MainActivity : AppCompatActivity() {
    lateinit var Edt_Email:EditText
    private lateinit var Edt_Pass: EditText
    lateinit var EdtConPaa: EditText
    private lateinit var Btn_Register: Button
    lateinit var texttologin: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        texttologin=findViewById(R.id.Txt_Gotologin)
        texttologin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            auth = Firebase.auth
        }
        auth = Firebase.auth
        Btn_Register = findViewById(R.id.Btn_Register)
        Btn_Register.setOnClickListener {
            val intent = Intent(this, NewsActivity2::class.java)
            startActivity(intent)

            SignUpUser()
        }

    }

    private fun SignUpUser(){
        val email=Edt_Email.text.toString()
        val pass=Edt_Pass.text.toString()
        val confirmpass=EdtConPaa.text.toString()
        if (email.isBlank() || pass.isBlank() || confirmpass.isBlank()){
            Toast.makeText(this,"Please Email and password cant be blank",Toast.LENGTH_LONG).show()
            return
        }  else if (pass != confirmpass){
            Toast.makeText(this,"Password do not match",Toast.LENGTH_LONG).show()
            return

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed successfully",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create",Toast.LENGTH_LONG).show()
            }

        }
    }
}