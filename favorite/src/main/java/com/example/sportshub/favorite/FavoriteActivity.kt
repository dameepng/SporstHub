// FavoriteActivity.kt
package com.example.sportshub.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoriteFragment())
                .commit()
        }
    }
}
