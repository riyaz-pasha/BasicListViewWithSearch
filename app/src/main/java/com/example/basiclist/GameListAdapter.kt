package com.example.basiclist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.basiclist.databinding.CustomListBinding

class GameListAdapter(private val data: List<Game>) :
    RecyclerView.Adapter<GameListAdapter.ViewHolder>(), Filterable {

    var gameFilterList = data;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = gameFilterList[position]
        holder.bind(game)
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val resultList = ArrayList<Game>()
                if (constraint.isNullOrEmpty()) {
                    resultList.addAll(data)
                } else {
                    for (game in data) {
                        if ((game.getTitle().toLowerCase() + game.getDescription().toLowerCase())
                                .contains(constraint.toString().toLowerCase())
                        ) {
                            resultList.add(game)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = resultList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                gameFilterList = results?.values as List<Game>
                notifyDataSetChanged()
            }

        }
    }


    override fun getItemCount() = gameFilterList.size

    class ViewHolder(private val binding: CustomListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.title.text = game.title
            binding.description.text = game.description
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CustomListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}