package net.kathir.corountines.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.kathir.corountines.R
import net.kathir.corountines.model.Post
import org.jetbrains.anko.find

class PostAdapter(val list:List<Post>,val context: Context) : RecyclerView.Adapter<PostAdapter.ItemHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_post,parent,false))
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val titleTextView = itemView.find<TextView>(R.id.tv_title)
        private val bodyTextView = itemView.find<TextView>(R.id.tv_text)

        fun bind(post: Post)
        {
            titleTextView.text = post.title
            bodyTextView.text = post.body
        }
    }
}