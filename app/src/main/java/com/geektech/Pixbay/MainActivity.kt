package com.geektech.Pixbay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import coil.base.R
import com.geektech.Pixbay.databinding.ActivityMainBinding
import com.geektech.Pixbay.model.PixaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var photoAdapter = PhotoAdapter(arrayListOf())
    var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.requestByImage(++page)
                }
            }
        })
    }

    private fun initClickers() {
        with(binding) {
            addBtn.setOnClickListener(){
                requestByImage(++page)
            }
            changeBtn.setOnClickListener {
                requestByImage(page)
            }
            getImageBtn.setOnClickListener {
                page = 1
                requestByImage(page)

            }
                    }
    }

    private fun ActivityMainBinding.requestByImage(page:Int) {

        App.api.getImage(keyWord = photoEd.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    response.body()?.hits?.forEach {
                        photoAdapter.addList(it)
                    }

                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {

                }
            })

    }

}