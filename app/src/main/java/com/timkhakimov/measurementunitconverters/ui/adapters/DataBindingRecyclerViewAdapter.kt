package com.timkhakimov.measurementunitconverters.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by Timur Khakimov on 22.03.2020
 */
abstract class DataBindingRecyclerViewAdapter<M> : RecyclerView.Adapter<DataBindingRecyclerViewHolder>() {

    protected var listItems = mutableListOf<M>()

    init {
        listItems = ArrayList()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingRecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(getLayoutRes(viewType), parent, false)
        return DataBindingRecyclerViewHolder(v)
    }

    override fun onBindViewHolder(holder: DataBindingRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getVariableId(getItemViewType(position)), item)
    }

    @LayoutRes
    protected abstract fun getLayoutRes(viewType: Int): Int

    protected abstract fun getVariableId(viewType: Int): Int

    override fun getItemCount(): Int {
        return getItems().size
    }

    fun setItems(items: List<M>) {
        this.listItems = items.toMutableList()
        notifyDataSetChanged()
    }

    fun addItems(itemList: List<M>) {
        val size = itemCount
        listItems.addAll(itemList)
        notifyItemRangeInserted(size, itemList.size)
    }

    fun addItems(position: Int, itemList: List<M>) {
        listItems.addAll(position, itemList)
        notifyItemRangeInserted(position, itemList.size)
    }

    fun addItem(item: M) {
        listItems.add(item)
        notifyItemInserted(listItems.size - 1)
    }

    fun addItem(position: Int, item: M) {
        listItems.add(position, item)
        notifyItemInserted(position)
    }

    fun removeAt(position: Int) {
        listItems.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeAll() {
        listItems.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): M {
        return getItems()[position]
    }

    fun getItems(): List<M> {
        return listItems
    }

    fun clear() {
        removeAll()
    }
}