package com.example.hp.submission1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        return ViewHolder(ListUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        var idImage : ImageView
        var idName : TextView

        init {
            idImage = view.findViewById(ListUI.imageId)
            idName = view.findViewById(ListUI.nameId)
        }

        fun bindItem (items : Item, listener : (Item) -> Unit){
            idName.text = items.name
            items.image?.let { Picasso.get().load(it).into(idImage) }
            view.setOnClickListener {
                listener(items)
            }
        }
    }
}