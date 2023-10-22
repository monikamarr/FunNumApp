package com.example.funnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.android.material.snackbar.Snackbar
import okhttp3.Headers
import com.google.android.material.switchmaterial.SwitchMaterial


class MainActivity : AppCompatActivity() {

//    private lateinit var numsList: MutableList<String>
    private lateinit var numsAdapter: NumAdapter

    private lateinit var recyclerViewNum: RecyclerView

    private var isRandomMode = true // Initial mode is random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Create dummy data for testing
//        val sampleData = mutableListOf(
//            "Item 1",
//            "Item 2",
//            "Item 3",
//            "Item 4",
//            "Item 5",
//            "Item 6",
//            "Item 7")
        recyclerViewNum = findViewById<RecyclerView>(R.id.num_list)
//        numsList = mutableListOf<String>()
        numsAdapter = NumAdapter(mutableListOf())

        recyclerViewNum.adapter = numsAdapter

        recyclerViewNum.adapter = numsAdapter
        recyclerViewNum.layoutManager = LinearLayoutManager(this)
        recyclerViewNum.addItemDecoration((DividerItemDecoration(this, LinearLayoutManager.VERTICAL)))

        val button = findViewById<Button>(R.id.getInfoButton)
        val toggleButton = findViewById<Button>(R.id.switchToggle)
        val modeTextView = findViewById<TextView>(R.id.modeTextView)

        updateModeTextView() // Initialize the mode text

        button.setOnClickListener {

            // Show a Snackbar when the button is clicked
//            Snackbar.make(it, "Button Clicked", Snackbar.LENGTH_SHORT).show()
            Toast.makeText(this, "New Data Pulled", Toast.LENGTH_SHORT).show()
            val numberEditText = findViewById<EditText>(R.id.numberInput)
            val userNumber = numberEditText.text.toString()

            if (isRandomMode) {
                val random = (1..100).random()
                getNumInfo1(random.toString())
                getNumInfo2(random.toString())
                getNumInfo3(random.toString())
                getNumInfo4(random.toString())
                getNumInfo5(random.toString())
                getNumInfo6(random.toString())
                getNumInfo7(random.toString())
            } else if (userNumber.isNotBlank()) {
                getNumInfo1(userNumber)
                getNumInfo2(userNumber)
                getNumInfo3(userNumber)
                getNumInfo4(userNumber)
                getNumInfo5(userNumber)
                getNumInfo6(userNumber)
                getNumInfo7(userNumber)

            } else {
                // Handle the case when the user didn't enter a number
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
//                numsAdapter.addItem(year)
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
    private fun getNumInfo4(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/year?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo4 = findViewById<TextView>(R.id.randomInfo4)

                val math = json.jsonObject.optString("text")
                randomInfo4.text = math
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
    private fun getNumInfo5(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/trivia?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo5 = findViewById<TextView>(R.id.randomInfo5)

                val math = json.jsonObject.optString("text")
                randomInfo5.text = math
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
    private fun getNumInfo6(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/math?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo6 = findViewById<TextView>(R.id.randomInfo6)

                val math = json.jsonObject.optString("text")
                randomInfo6.text = math
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
    private fun getNumInfo7(userNumber: String) {
        val client = AsyncHttpClient()
        val apiUrl = "http://numbersapi.com/$userNumber/year?json"

        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("DEBUG OBJECT", json.jsonObject.toString())

                val randomInfo7 = findViewById<TextView>(R.id.randomInfo7)

                val math = json.jsonObject.optString("text")
                randomInfo7.text = math
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
