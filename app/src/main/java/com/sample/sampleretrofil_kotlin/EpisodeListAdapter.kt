package com.sample.sampleretrofil_kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.itemview_episode_list.view.*

/**
 * Created by Shivam Jaiswal on 11/09/18.
 */
class EpisodeListAdapter(var context: Context, var list: ArrayList<Episodes.Episode>) : RecyclerView.Adapter<EpisodeListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.itemview_episode_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.date.text = "Released on ${list[position].released}"
        holder.rating.text = "Rating ${list[position].imdbRating}"
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title
        val date = view.date
        val rating = view.rating
    }
}