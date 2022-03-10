package com.example.projecttask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttask.R
import com.example.projecttask.apis.TaskDetail
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.databinding.ItemSimpleBinding
import java.util.*


class ItemListAdapter(private val dataList: List<Any>, val onClick: ((item: Any) -> Unit)? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _binding: ItemSimpleBinding? = null
    private val binding get() = _binding!!
    override fun getItemViewType(position: Int) = R.layout.item_simple


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        _binding = ItemSimpleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ItemViewHolder(private val itemBinding: ItemSimpleBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemData: Any) {
            // TODO: bind item data
            when (itemData) {
                is TaskDetail -> {
                    itemBinding.tvTaskNameValue.text = itemData.tasks.task_name
                    itemBinding.tvTaskStartDateValue.text = itemData.tasks.task_start_date
                    itemBinding.tvTaskEndDateValue.text = itemData.tasks.task_end_date
                    itemBinding.tvTaskStatusValue.text = "Đang tiến hành" // TODO: @nhuan correct here
                }
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList.get(position)
        (holder as? ItemViewHolder)?.bind(item)

        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }
}


