package com.example.kotlinrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinrecyclerview.models.Live
import kotlinx.android.synthetic.main.res_item_live.view.author
import kotlinx.android.synthetic.main.res_item_live.view.thumbnail
import kotlinx.android.synthetic.main.res_item_live.view.title

class LiveAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is LiveViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun setDataSet(lives : List<Live>) {
        this.items = lives
    }

    class LiveViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        @SuppressLint("CheckResult")
        fun bind(live: Live) {
            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailUrl)
                .into(liveThumbnail)

        }

    }

}