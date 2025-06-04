package com.example.recipelogger.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.recipelogger.databinding.FragmentListBinding
import com.example.recipelogger.roomdb.RecipeDAO
import com.example.recipelogger.roomdb.RecipeDatabase

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: RecipeDatabase
    private lateinit var recipeDao: RecipeDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db= Room.databaseBuilder(requireContext(), RecipeDatabase::class.java,"Recipes").build()
        recipeDao=db.recipeDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            val action= ListFragmentDirections.actionListFragmentToRecipeFragment(information = "new", id = 0)
            Navigation.findNavController(view).navigate(action)
        }
    }


}