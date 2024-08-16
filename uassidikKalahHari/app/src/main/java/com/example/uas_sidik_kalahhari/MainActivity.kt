package com.example.discussionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_topics)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data for topics
        val topics = listOf("Akademik", "Keuangan", "Umum")
        val adapter = TopicsAdapter(topics) { topic ->
            // OnClickListener for each topic
            val intent = Intent(this, DiscussionActivity::class.java)
            intent.putExtra("TOPIC_NAME", topic)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}