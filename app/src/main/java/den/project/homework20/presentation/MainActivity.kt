package den.project.homework20.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import den.project.homework20.databinding.ActivityMainBinding
import den.project.homework20.domain.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModels()
    private var setTextView: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.messageTextToMainActivity.observe(this, {
            textView0.text = it.toString()
        })
    }

    override fun onResume() {
        super.onResume()
        push(textView0)
        push(textView1)
        push(textView2)
        push(textView3)
        push(textView4)
        push(textView5)
//        textView0.text = setTextView
    }

    private fun push(view: TextView?) {
        view?.setOnClickListener {
            val addPhotoBottomDialogFragment = BottomShieldDialog.newInstance()
            addPhotoBottomDialogFragment.show(
                supportFragmentManager,
                BottomShieldDialog.TAG
            )
        }

    }
}


