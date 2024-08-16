package com.example.discussionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class ChatRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)

        val discussionTitle = intent.getStringExtra("DISCUSSION_TITLE")

        // Set toolbar title to the discussion title
        supportActionBar?.title = discussionTitle

        val recyclerView = findViewById<RecyclerView>(R.id.rv_chat_messages)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data for chat messages
        val messages = listOf(
            ChatMessage("51920337 Yadi", "03/04/2024 8:28 AM", "Izin bertanya, untuk jatuh tempo, kapan yah?"),
            ChatMessage("Agus Rasyid S. Kom, M. Si", "03/04/2024 8:27 AM", "Jatuh tempo pembayaran pada tanggal 20 Desember 2020. Terima kasih."),
            ChatMessage("28937716 Nur Adysa", "03/04/2024 8:27 AM", "Izin bertanya untuk ketentuan buku jurusan teknik wajib punya?"),
            ChatMessage("Agus Rasyid S. Kom, M. Si", "03/04/2024 8:27 AM", "Iya betul."),
            ChatMessage("Agus Rasyid S. Kom, M. Si", "03/04/2024 8:27 AM", "Mahasiswa tolong isi link berikut untuk akademik jurusan kita ya https://mmm.akademik.com"),
            ChatMessage("2993002 Hasyim Putri", "03/04/2024 8:29 AM", "Baik Pak")
        )
        val adapter = ChatAdapter(messages)
        recyclerView.adapter = adapter

        val btnSend = findViewById<ImageButton>(R.id.btn_send)
        val etMessage = findViewById<EditText>(R.id.et_message)

        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            if (message.isNotEmpty()) {
                // Send the message (you would typically call an API or update the chat list here)
                Snackbar.make(recyclerView, "Message sent: $message", Snackbar.LENGTH_SHORT).show()
                etMessage.text.clear()
            }
        }
    }
}