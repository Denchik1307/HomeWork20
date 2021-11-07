package den.project.homework20

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val listCard: Resources = resources
        val list = listCard.getStringArray(R.array.video_card)
        for (item in list) {
            Log.d("MyLog", item.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        push(textView0)
        push(textView1)
        push(textView2)
        push(textView3)
        push(textView4)
        push(textView5)
    }

    private fun push(view: TextView?) {
        view?.setOnClickListener {
            val addPhotoBottomDialogFragment = BottomShieldDialog.newInstance()
            addPhotoBottomDialogFragment.show(
                supportFragmentManager,
                BottomShieldDialog.toString()
            )
            view.text = "select"
        }
    }


}


