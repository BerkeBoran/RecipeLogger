package com.example.recipelogger.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.recipelogger.adapter.RecipeAdapter
import com.example.recipelogger.databinding.FragmentListBinding
import com.example.recipelogger.model.Recipe
import com.example.recipelogger.roomdb.RecipeDAO
import com.example.recipelogger.roomdb.RecipeDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: RecipeDatabase
    private lateinit var recipeDao: RecipeDAO
    private val mDisposable = CompositeDisposable()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db= Room.databaseBuilder(requireContext(), RecipeDatabase::class.java,"Recipes").fallbackToDestructiveMigration().build()

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
        getData()
        binding.floatingActionButton.setOnClickListener {
            val action= ListFragmentDirections.actionListFragmentToRecipeFragment(information = "new", id = 0)
            Navigation.findNavController(view).navigate(action)
        }
        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(requireContext())


    }
    private fun getData() {
        mDisposable.add(
            recipeDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )
    }

    private fun handleResponse(recipes: List<Recipe>) {
        val adapter = RecipeAdapter(recipes)
        binding.recipeRecyclerView.adapter = adapter


    }


}