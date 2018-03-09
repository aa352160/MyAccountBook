package com.rongke.myaccountbook.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rongke.myaccountbook.R
import com.rongke.myaccountbook.bean.MainRecordBean
import com.rongke.myaccountbook.database.model.BillRecordDataModel
import com.rongke.myaccountbook.util.RecordTypeHelper
import com.rongke.myaccountbook.util.castToTimeDetailStr
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_index_list.*
import org.w3c.dom.Text

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
            val reversDatas = datas.reversed()
            reversDatas.forEach{
                val view = LayoutInflater.from(context).inflate(R.layout.item_index_record, ll_record,false)
                view.findViewById<ImageView>(R.id.iv_record_type).setImageDrawable(
                        context.getDrawable(RecordTypeHelper.getRecordTypeById(it.type).typeImgResId))
                view.findViewById<TextView>(R.id.tv_record_time).text = it.createTimeDetail.castToTimeDetailStr()
                view.findViewById<TextView>(R.id.tv_record_title).text = it.title
                if (it.isIncome){
                    view.findViewById<TextView>(R.id.tv_record_money).text = "+${it.price}"
                }else{
                    view.findViewById<TextView>(R.id.tv_record_money).text = "-${it.price}"
                }
                ll_record.addView(view)
            }
        }
    }
}