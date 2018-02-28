package com.rongke.myaccountbook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.bean.MainRecordBean
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_index_list.*

/**
 * Created by jh352160 on 2018/2/5.
 */

class IndexAdapter(private val context: Context, private val datas : List<MainRecordBean>?) :
        RecyclerView.Adapter<IndexAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_index_list, parent, false))

    override fun getItemCount(): Int = datas!!.size

    override fun onBindViewHolder(holder: IndexAdapter.ViewHolder, position: Int) {
        val item = datas?.get(position)
        holder.setText(item!!.createTime)
        holder.setNewRecordList(item.recordList)
    }

    inner class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun setText(text : String){
            item_text.text = text
        }

        fun setNewRecordList(datas : List<BillRecordDataModel>){
            ll_record.removeAllViews()
            for (item in datas){
                val view = LayoutInflater.from(context).inflate(R.layout.item_index_record, ll_record,false)
                if (item.isIncome){
                    view.findViewById<TextView>(R.id.tv_record_money).text = "+${item.price}"
                }else{
                    view.findViewById<TextView>(R.id.tv_record_money).text = "-${item.price}"
                }
                ll_record.addView(view)
            }
        }
    }
}