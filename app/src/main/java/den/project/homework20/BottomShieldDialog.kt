package den.project.homework20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import den.project.homework20.card.ListCard
import den.project.homework20.card.MyAdapter
import kotlinx.android.synthetic.main.make_pattern_fragment.*

class BottomShieldDialog : BottomSheetDialogFragment() {
    private val myAdapter by lazy { MyAdapter() }
    private val listCard by lazy { ListCard() }

    companion object {
        fun newInstance(): BottomShieldDialog {
            return BottomShieldDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.make_pattern_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        myAdapter.makeList(listCard.listCard)
    }

    private fun initRecycler() {
        make_bottom_shield.adapter = myAdapter

        myAdapter.setOnItemClickListener { model ->
        }
    }
}
