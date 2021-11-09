package den.project.homework20.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<CardHolder>() {

    private var item: List<Card> = mutableListOf()

    private var itemClickListener: ((Card) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CardHolder {
        val holder = CardHolder.from(parent)
        holder.setItemClickListener { model ->
            itemClickListener?.invoke(model)
        }
        return holder
    }

    override fun onBindViewHolder(holder: CardHolder, place: Int) {
        holder.bindView(item[place])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun makeList(data: List<Card>) {
        item = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Card) -> Unit) {
        itemClickListener = listener
    }
}