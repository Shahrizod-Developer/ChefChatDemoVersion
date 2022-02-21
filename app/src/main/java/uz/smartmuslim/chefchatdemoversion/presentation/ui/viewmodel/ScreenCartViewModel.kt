package uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenCartViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is cart Fragment"
    }
    val text: LiveData<String> = _text
}