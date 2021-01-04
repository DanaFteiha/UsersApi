package com.example.usersapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    //val imageView : ImageView = itemView.findViewById(R.id.userImage)
    val textView1 : TextView = itemView.findViewById(R.id.username)
    val textView2 : TextView = itemView.findViewById(R.id.gender)
    val textView3 : TextView = itemView.findViewById(R.id.email)

}
