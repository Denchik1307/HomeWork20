package den.project.homework20.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import den.project.homework20.data.ListCard
import den.project.homework20.databinding.MakePatternFragmentBinding
import den.project.homework20.domain.ViewModel
import den.project.homework20.presentation.recycler.CardHolderAdapter
import kotlinx.android.synthetic.main.make_pattern_fragment.*

class BottomShieldDialog : BottomSheetDialogFragment() {
    lateinit var binding: MakePatternFragmentBinding
    private val myAdapter by lazy { CardHolderAdapter() }
    private val listCard by lazy { ListCard() }
    private val viewModel: ViewModel by activityViewModels()

    companion object {
        const val TAG = "MARKER"
        fun newInstance(): BottomShieldDialog {
            return BottomShieldDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MakePatternFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        myAdapter.makeList(listCard.listCard)
    }

    private fun initRecycler() {
        BottomRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener { card ->
            viewModel.messageTextToMainActivity.value = card.id
            Toast.makeText(context, "You selected: " + card.id, Toast.LENGTH_LONG).show()
            dismiss()
        }
    }
}
