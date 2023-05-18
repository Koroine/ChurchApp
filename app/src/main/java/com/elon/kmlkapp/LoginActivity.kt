package com.elon.kmlkapp
//import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var texttoreg:TextView
    lateinit var Buttonnews:Button
    lateinit var auth: FirebaseAuth
    lateinit var Edtemail:EditText
    lateinit var Edtpass:EditText
//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Edtemail=findViewById(R.id.Edt_Email)
        Edtpass=findViewById(R.id.Edt_pass)


        texttoreg=findViewById(R.id.Txt_GotoReg)
        texttoreg.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()
        Buttonnews=findViewById(R.id.Btn_Login)

        Buttonnews.setOnClickListener {
           val intent=Intent(this,NewsActivity2::class.java)
            startActivity(intent)
            login()

        }
    }
    private fun login() {
        val email = Edtemail.text.toString()
        val pass = Edtpass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully signed in", Toast.LENGTH_LONG).show()
                val intent = Intent(this, NewsActivity2::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Successfully signed in", Toast.LENGTH_LONG).show()
            }
        }
    }
}