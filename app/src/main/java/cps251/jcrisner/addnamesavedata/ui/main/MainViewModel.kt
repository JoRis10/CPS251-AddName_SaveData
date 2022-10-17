package cps251.jcrisner.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _nameList = ""
    val nameList : String
        get() = _nameList

    fun setList(fullText : String){
        this._nameList = fullText
    }

}