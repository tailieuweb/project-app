package com.example.projecttask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttask.R
import com.example.projecttask.apis.TaskDetail
import com.example.projecttask.apis.WebServiceApi
import com.example.projecttask.data.model.NotificationModel
import com.example.projecttask.databinding.ItemNotificationBinding
import com.example.projecttask.databinding.ItemSimpleBinding


class NotificationListAdapter(private val dataList: List<Any>, val onClick: ((item: Any) -> Unit)? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var _binding: ItemNotificationBinding? = null
    private val binding get() = _binding!!
    override fun getItemViewType(position: Int) = R.layout.item_notification


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        _binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ItemViewHolder(private val itemBinding: ItemNotificationBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemData: Any) {
            // TODO: bind item data
            when (itemData) {
                is NotificationModel -> {
                    itemBinding.tvTitle.text = itemData.description
                    itemBinding.tvValue.text = itemData.taskId
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


