class TopicsAdapter(
    private val topics: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.bind(topic, onClick)
    }

    override fun getItemCount() = topics.size

    class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(android.R.id.text1)

        fun bind(topic: String, onClick: (String) -> Unit) {
            textView.text = topic
            itemView.setOnClickListener { onClick(topic) }
        }
    }
}

class DiscussionsAdapter(
    private val discussions: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<DiscussionsAdapter.DiscussionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscussionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return DiscussionViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscussionViewHolder, position: Int) {
        val discussion = discussions[position]
        holder.bind(discussion, onClick)
    }

    override fun getItemCount() = discussions.size

    class DiscussionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(android.R.id.text1)

        fun bind(discussion: String, onClick: (String) -> Unit) {
            textView.text = discussion
            itemView.setOnClickListener { onClick(discussion) }
        }
    }
}

class ChatAdapter(
    private val messages: List<ChatMessage>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    override fun getItemCount() = messages.size

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvUserName: TextView = view.findViewById(R.id.tv_user_name)
        private val tvTimestamp: TextView = view.findViewById(R.id.tv_timestamp)
        private val tvMessage: TextView = view.findViewById(R.id.tv_message)

        fun bind(message: ChatMessage) {
            tvUserName.text = message.userName
            tvTimestamp.text = message.timestamp
            tvMessage.text = message.message
        }
    }
}

> Muhamad Sidik:
data class ChatMessage(
    val userName: String,
    val timestamp: String,
    val message: String
)
