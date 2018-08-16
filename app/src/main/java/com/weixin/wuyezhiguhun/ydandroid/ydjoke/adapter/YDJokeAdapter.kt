package com.weixin.wuyezhiguhun.ydandroid.ydjoke.adapter

import android.app.Activity
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.data.YDJokeInfo
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.weixin.wuyezhiguhun.ydandroid.R


class YDJokeAdapter(val mContext: Activity, val layoutRes: Int, var dataList: List<YDJokeInfo>)
    : RecyclerView.Adapter<YDJokeAdapter.ViewHolder>() {

    private var onItemClickListener: AdapterView.OnItemClickListener? = null
    private var onItemLongClickListener: AdapterView.OnItemLongClickListener? = null


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YDJokeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_yd_joke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: YDJokeAdapter.ViewHolder, position: Int) {
        val joke_info: YDJokeInfo = dataList[position]

        val resId: Int = mContext.getResources().getIdentifier(joke_info.image_name, "drawable",mContext.getPackageName())

        if (resId > 0) {
            holder.mImageView.setImageResource(resId)
        }
        holder.mText.text = joke_info.content

        val adapterPosition = holder.adapterPosition
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(YDOnClickListener(position, joke_info))
        }
        if (onItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(YDOnLongClickListener(position, joke_info))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mText: TextView
        var mImageView: ImageView
        init {
            mText = itemView.findViewById(R.id.item_joke_content)
            mImageView = itemView.findViewById(R.id.item_joke_image)
        }
    }


    class YDOnLongClickListener(private val position: Int, private val data: YDJokeInfo) : View.OnLongClickListener {

        override fun onLongClick(v: View): Boolean {

            println("wuyezhiguhun --- longClick")

//            OnItemLoginClickListener.

            //           OnItemLoginClickListener.onItemLongClick(v, position, data)

            return true
        }
    }

    class YDOnClickListener(private val position: Int, private val data: YDJokeInfo) : View.OnClickListener {

        override fun onClick(v: View) {

            println("wuyezhiguhun --- click")
            //            onItemClickListener.onItemClick(v, position, data);
        }
    }


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, data: YDJokeInfo)
    }

    interface OnItemLoginClickListener {
        fun onItemLongClick(view: View, position: Int, data: YDJokeInfo)
    }


}