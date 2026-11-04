package com.gmt.playlistmaker

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged


class SearchActivity : AppCompatActivity() {
    private var searchText = ""
    private lateinit var etSearch: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        etSearch = findViewById(R.id.et_search)
        val cleanSearch = findViewById<ImageView>(R.id.clean_search)

        etSearch.doOnTextChanged { text, _, _, _ ->
            searchText = text?.toString().orEmpty()
            cleanSearch.isVisible = !text.isNullOrEmpty()
        }

        cleanSearch.setOnClickListener {
            etSearch.setText("")
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(etSearch.windowToken, 0)
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_TEXT_KEY, searchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val value = savedInstanceState.getString(SEARCH_TEXT_KEY)
        etSearch.setText(value)
    }
    companion object {
        const val SEARCH_TEXT_KEY = "search_text_key"
    }

}