package com.recipebook.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.recipebook.databinding.ActivityMainBinding
import com.recipebook.models.RecipeBook
import com.recipebook.models.RecipeBookResult
import com.recipebook.viewmodel.RecipeBookViewModel
import com.recipebook.views.adapter.RecipeBookAdapter
import com.recipebook.views.component.RecipeBookDetBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    private val viewModelRecipeBook: RecipeBookViewModel by viewModels()

    private var listRecipeBookObserver = Observer<RecipeBookResult> { recipeBookResult ->
        if (recipeBookResult.susses) {
            recipeBookResult.list?.let {
                val adapter = RecipeBookAdapter(
                    it,
                    onItemClickListener,
                    applicationContext
                )
                binding?.recyclerView?.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initRecycler()
        initObserver()
        viewModelRecipeBook.getRecipeBook()
    }

    private var onItemClickListener: ((recipeBook: RecipeBook) -> Unit) = { product ->
        Toast.makeText(this ,"Product:" + product.name, Toast.LENGTH_SHORT).show()
        RecipeBookDetBottomSheet.newInstance(product.name, product.productPhoto, product.recipeBooks)
            .show(supportFragmentManager,"")
    }


    private fun initObserver() {
        viewModelRecipeBook.listRecipeBook.observe(this, listRecipeBookObserver)

    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            //itemAnimator = DefaultItemAnimator()
      }
    }
}





