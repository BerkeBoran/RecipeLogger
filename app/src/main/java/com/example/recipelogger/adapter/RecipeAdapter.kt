package com.example.recipelogger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipelogger.databinding.RecyclerRowBinding
import com.example.recipelogger.model.Recipe
import com.example.recipelogger.view.ListFragmentDirections

class RecipeAdapter(val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecipeHolder {
        val recyclerRowBinding =
            RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeHolder(recyclerRowBinding)

    }

    override fun onBindViewHolder(
        holder: RecipeHolder,
        position: Int,
    ) {
        holder.binding.recyclerViewTextView.text = recipeList[position].name
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToRecipeFragment(
                information = "used",
                id = recipeList[position].id
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class RecipeHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}