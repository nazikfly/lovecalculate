package com.geektech.Pixbay

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.Pixbay.databinding.ItemLayoutBinding
import com.geektech.Pixbay.model.ImageModel

class PhotoAdapter(var list: ArrayList<ImageModel>):RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){
    class PhotoViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind (imageModel: ImageModel) {
         binding.photoImg.load(imageModel.largeImageURL)
        }
    }
    fun addList(image:ImageModel){
        list.add(image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
            parent,
            false
            ))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(list[position])
           }

    override fun getItemCount(): Int {
        return list.size
            }

}