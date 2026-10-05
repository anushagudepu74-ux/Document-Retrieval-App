package com.example.documentretrievalapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etQuery: EditText
    private lateinit var btnSearch: Button
    private lateinit var tvResults: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etQuery = findViewById(R.id.etQuery)
        btnSearch = findViewById(R.id.btnSearch)
        tvResults = findViewById(R.id.tvResults)
        progressBar = findViewById(R.id.progressBar)

        btnSearch.setOnClickListener {

            val query = etQuery.text.toString().trim()

            if (query.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter a question",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            progressBar.visibility = ProgressBar.VISIBLE

            tvResults.text =
                """
                Search Query:
                $query

                Retrieval Result:

                This is a local document retrieval demonstration.

                The Python backend and vector search can be
                connected after the Android application is
                running correctly.
                """.trimIndent()

            progressBar.visibility = ProgressBar.GONE
        }
    }
}