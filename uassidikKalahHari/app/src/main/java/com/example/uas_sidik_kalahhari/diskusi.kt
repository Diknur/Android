package com.example.discussionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DiscussionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discussion)

        val topicName = intent.getStringExtra("TOPIC_NAME")

        // Set toolbar title to the topic name
        supportActionBar?.title = topicName

        val recyclerView = findViewById<RecyclerView>(R.id.discussion_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data for discussions
        val discussions = listOf("Jadwal Pembayaran", "Buku Wajib Teknik", "Kegiatan Mahasiswa")
        val adapter = DiscussionsAdapter(discussions) { discussion ->
            // OnClickListener for each discussion
            val intent = Intent(this, ChatRoomActivity::class.java)
            intent.putExtra("DISCUSSION_TITLE", discussion)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}