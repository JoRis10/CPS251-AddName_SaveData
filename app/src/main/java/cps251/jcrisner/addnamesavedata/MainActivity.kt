package cps251.jcrisner.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cps251.jcrisner.addnamesavedata.databinding.ActivityMainBinding
import cps251.jcrisner.addnamesavedata.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        listFragment = supportFragmentManager.findFragmentById(R.id.fragmentNameList) as MainFragment
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val userInput : String
        if(binding.enterNameBox.text.isNotEmpty()){
            userInput = binding.enterNameBox.text.toString()
        }
        else{
            userInput = ""
        }
        outState.putCharSequence("savedInput", userInput)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val userInput = savedInstanceState.getCharSequence("savedInput")
        binding.enterNameBox.setText(userInput)
    }

    fun addName(view: View){
        if(binding.enterNameBox.text.isNotEmpty()){
            listFragment.createList(binding.enterNameBox.text.toString())
        }
    }

}