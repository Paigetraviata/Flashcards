package com.example.mobil

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DecksAdapter(val context: Context, private val myList : ArrayList<String>) : RecyclerView.Adapter<DecksAdapter.ViewHolder>() {

    lateinit var listener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        this.listener = listener

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val myDecksItem = LayoutInflater.from(viewGroup.context).inflate(R.layout.deck_item, viewGroup, false)

        return ViewHolder(myDecksItem, listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val newList = myList[position]

        viewHolder.bind(newList)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    inner class ViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        private val textItem = itemView.findViewById<TextView>(R.id.txt)

        fun bind(deckItem : String){
            textItem.text = deckItem
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }


}