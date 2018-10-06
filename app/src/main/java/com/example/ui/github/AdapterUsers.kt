package com.example.ui.github

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.network.response.User
import com.example.ui.BaseViewHolder
import com.example.githubusers.R
import com.example.ui.inflateView
import kotlinx.android.synthetic.main.single_user_row.view.*

class AdapterUsers : RecyclerView.Adapter<BaseViewHolder>() {
    var userList = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            MyViewHolder(p0.inflateView(R.layout.single_user_row))

    override fun getItemCount() = userList.size

    override
    fun onBindViewHolder(p0: BaseViewHolder, p1: Int) = p0.onBind()

    inner class MyViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun onBind() {
            val single = userList[adapterPosition]
            itemView.tvName.text = single.login
            itemView.tvScore.text = single.score?.toString()
        }
    }
}