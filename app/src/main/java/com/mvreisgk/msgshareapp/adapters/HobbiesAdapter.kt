package com.mvreisgk.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mvreisgk.msgshareapp.models.Hobby
import com.mvreisgk.msgshareapp.R
import com.mvreisgk.msgshareapp.activities.SecondActivity
import com.mvreisgk.msgshareapp.showToast

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = HobbiesAdapter::class.java.simpleName
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked!")
                }
            }

            itemView.findViewById<ImageView>(R.id.imgShare).setOnClickListener {
                currentHobby?.let {
                    val message: String = "My hobby is: " + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Share to:"))
                }
            }
        }

        fun setData(hobby: Hobby?, position: Int){
            hobby?.let{
                itemView.findViewById<TextView>(R.id.txvTitle).text = hobby.title
                this.currentHobby = hobby
                this.currentPosition = currentPosition
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}