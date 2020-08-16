package com.mani.mysharedpreferencedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var  etFirstName : EditText?=null
    var  etLastName : EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirstName   = findViewById(R.id.etFirstName)
        etLastName   = findViewById(R.id.etLastName)

        getReterieveDataFromSharedPreference()
        findViewById<TextView>(R.id.tvSave).setOnClickListener {

            val firstName = etFirstName!!.text.toString()
            val lastName = etLastName!!.text.toString()

            val sharedPreference = getSharedPreferences("MyPrefName", Context.MODE_PRIVATE)
            val editor           = sharedPreference.edit()

            editor.putString("FNAME",firstName)
            editor.putString("LNAME",lastName)


            editor.apply()

        }



        findViewById<TextView>(R.id.tvClear).setOnClickListener {

            val sharedPreference = getSharedPreferences("MyPrefName", Context.MODE_PRIVATE)
            val editor           = sharedPreference.edit()
            editor.clear()
            editor.apply()

            getReterieveDataFromSharedPreference()
        }
    }

    private fun getReterieveDataFromSharedPreference() {


        val sharedPreference = getSharedPreferences("MyPrefName", Context.MODE_PRIVATE)

       val fName    =  sharedPreference.getString("FNAME","")
        val lName   =  sharedPreference.getString("LNAME","")

        if(!fName!!.isEmpty() && !lName!!.isEmpty())
        {
            etFirstName!!.setText(""+fName)
            etLastName!!.setText(""+lName)
        }
        else
        {
            etFirstName!!.setText("")
            etLastName!!.setText("")

        }


    }
}