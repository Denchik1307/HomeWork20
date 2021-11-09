package den.project.homework20.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import den.project.homework20.R
import kotlinx.android.synthetic.main.fragment_bottom_shield.view.*

class CardHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): CardHolder {
            return CardHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.fragment_bottom_shield, parent, false)
            )
        }
    }

    private val modelTextView: TextView by lazy { itemView.title }

    private var itemClickListener: ((Card) -> Unit)? = null

    fun bindView(item: Card) {
        modelTextView.text = item.id

        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((Card) -> Unit)) {
        itemClickListener = listener
    }
}
