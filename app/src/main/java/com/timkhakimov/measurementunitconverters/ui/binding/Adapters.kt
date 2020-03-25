package com.timkhakimov.measurementunitconverters.ui.binding

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ListenerUtil
import androidx.recyclerview.widget.RecyclerView
import com.timkhakimov.measurementunitconverters.R
import com.timkhakimov.measurementunitconverters.presentation.handlers.StringHandler
import com.timkhakimov.measurementunitconverters.ui.adapters.DataBindingRecyclerViewAdapter

/**
 * Created by Timur Khakimov on 22.03.2020
 */
object Adapters {

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setData(recyclerView: RecyclerView, data: List<T>?) {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as DataBindingRecyclerViewAdapter<T>).setItems(
                data ?: mutableListOf()
            )
        }
    }

    @BindingAdapter("app:singleStringTextWatcher")
    @JvmStatic
    fun setSingleTextWatcher(textView: TextView, inputStringHandler : StringHandler) {
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let { inputStringHandler.handle(it.toString()) }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
        val oldWatcher = ListenerUtil.trackListener(textView, textWatcher, R.id.textWatcher);
        if(oldWatcher != null) {
            textView.removeTextChangedListener(oldWatcher);
        }
        textView.addTextChangedListener(textWatcher)
    }
}