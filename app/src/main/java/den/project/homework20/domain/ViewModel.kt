package den.project.homework20.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ViewModel: ViewModel() {

    val messageTextToMainActivity : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}