package com.example.funnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import com.google.android.material.switchmaterial.SwitchMaterial


class MainActivity : AppCompatActivity() {

    private var isRandomMode = true // Initial mode is random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.getInfoButton)
        val toggleButton = findViewById<Button>(R.id.switchToggle)
        val modeTextView = findViewById<TextView>(R.id.modeTextView)

        updateModeTextView() // Initialize the mode text

        button.setOnClickListener {
            val numberEditText = findViewById<EditText>(R.id.numberInput)
            val userNumber = numberEditText.text.toString()

            if (isRandomMode) {
                val random = (1..100).random()
                getNumInfo1(random.toString())
                getNumInfo2(random.toString())
                getNumInfo3(random.toString())
            } else if (userNumber.isNotBlank()) {
                getNumInfo1(userNumber)
                getNumInfo2(userNumber)
                getNumInfo3(userNumber)
            } else {
                // Handle the case when the user didn't enter a number
                // You might want to show an error message or provide feedback to the user
            }
        }

        toggleButton.setOnClickListener {
            isRandomMode = !isRandomMode
            updateModeTextView() // Update the mode text when the mode changes
        }
    }

    private fun updateModeTextView() {
        val modeTextView = findViewById<TextView>(R.id.modeTextView)
        if (isRandomMode) {
            modeTextView.text = "Random Mode"
        } else {
            modeTextView.text = "User Input Mode"
        }
    }

    private fun getNumInfo1(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/year?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo1 = findViewById<TextView>(R.id.randomInfo1)

                val year = json.jsonObject.optString("text")
                randomInfo1.text = year
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("Error", response)
            }
        })
    }

    private fun getNumInfo2(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/trivia?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo2 = findViewById<TextView>(R.id.randomInfo2)

                val trivia = json.jsonObject.optString("text")
                randomInfo2.text = trivia
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("Error", response)
            }
        })
    }

    private fun getNumInfo3(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/math?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo3 = findViewById<TextView>(R.id.randomInfo3)

                val math = json.jsonObject.optString("text")
                randomInfo3.text = math
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("Error", response)
            }
        })
    }
}
