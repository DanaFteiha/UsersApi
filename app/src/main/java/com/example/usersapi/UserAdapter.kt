package com.example.usersapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (private val activity: AppCompatActivity) : RecyclerView.Adapter<UserViewHolder>()  {

    private var personsList = ArrayList<Person>()
    private var displayList = ArrayList<Person>()

    init {
        //dummy data
        personsList.add(Person("Female", "danafteiha@gmail.com", "Dana Fteiha"))
        personsList.add(Person("Male", "nizar@gmail.com", "Nizar Fteiha"))
        displayList.addAll(personsList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.user_view,
                    parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val person = displayList[position]

        holder.textView1.text = person.name
        holder.textView2.text = person.gender
        holder.textView3.text = person.email
    }

    override fun getItemCount() = displayList.size

    fun setData(newList : List<Person>){
        personsList.clear()
        personsList.addAll(newList)
        displayList.clear()
        displayList.addAll(newList)
        notifyDataSetChanged()
    }

}
