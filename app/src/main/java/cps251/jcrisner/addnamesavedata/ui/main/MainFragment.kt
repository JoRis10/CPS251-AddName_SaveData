package cps251.jcrisner.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cps251.jcrisner.addnamesavedata.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.buttonAddName.setOnClickListener { this.addName()}
        if(viewModel.nameList != ""){binding.nameDisplay.setText(viewModel.nameList)}
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addName(){
        if(binding.enterNameBox.text.isNotEmpty()){
            val updatedList = viewModel.nameList + binding.enterNameBox.text + "\n"
            viewModel.setList(updatedList)
            binding.nameDisplay.text = updatedList
        }
    }

}