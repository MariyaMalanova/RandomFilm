package com.example.randomfilmk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var movies: Array<String>;
    val r = Random()
    var arr = emptyArray<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies = resources.getStringArray(R.array.movies)
        for (i in movies.indices) {
            arr += 0
        }
    }

    fun onNextClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)
        val tvNote = findViewById<TextView>(R.id.note)
        tvNote.text = ""
        for (i in movies.indices) {
            if (i == movies.size - 1) {
                tvNote.text = "Список закончился, начните заново"
            }
            val rand_chislo = r.nextInt(movies.size)
            if (arr[rand_chislo] == 0) {
                tvTitle.text = movies[rand_chislo]
                arr[rand_chislo] = 1
                break
            }
        }
    }

    fun onClearClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)
        val tvNote = findViewById<TextView>(R.id.note)
        for (i in movies.indices) {
            arr[i] = 0
        }
        tvTitle.text = ""
        tvNote.text = "Кликните 'Следующий фильм'"
    }
}
