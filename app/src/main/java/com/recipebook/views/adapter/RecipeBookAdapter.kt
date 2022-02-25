package com.recipebook.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.recipebook.R
import com.recipebook.models.RecipeBook

class RecipeBookAdapter(
    private val dataSource: MutableList<RecipeBook>,
    var onListHitItemClickListener: ((recipebook: RecipeBook) -> Unit),
    val context: Context
    ): RecyclerView.Adapter<RecipeBookAdapter.ViewHolder>()
{
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.namePlatillo) as TextView
        var produPhoto: ImageView = view.findViewById(R.id.img_prod) as ImageView
        var authorB: TextView = view.findViewById(R.id.tvAuthor) as TextView
        var root: ConstraintLayout =
            view.findViewById(R.id.layout_item_recipebook) as ConstraintLayout
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recipebook, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.name.text = dataSource[position].name
        viewHolder.authorB.text = dataSource[position].authorB


        Glide.with(context)// Asi se cargan las imagenes de la nube
            //.load(context.getDrawable(dataSource[position].productPhoto))
            .load(dataSource[position].productPhoto)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(viewHolder.produPhoto)

        viewHolder.root.setOnClickListener {
            onListHitItemClickListener.invoke(dataSource[position])
        }
    }
    override fun getItemCount() = dataSource.size
}