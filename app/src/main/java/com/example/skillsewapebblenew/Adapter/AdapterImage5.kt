package com.example.skillsewapebblenew.Adapter

import android.widget.ImageView
import com.example.skillsewapebblenew.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class AdapterImage5: Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.imageholder

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val image= viewHolder.itemView.findViewById<ImageView>(R.id.peopleImage)
        image.setImageResource(R.drawable.ic_image)
    }

}