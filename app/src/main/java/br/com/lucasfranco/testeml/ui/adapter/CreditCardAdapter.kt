package br.com.lucasfranco.testeml.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnCreditCardClick
import br.com.lucasfranco.testeml.model.CreditCard
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_credit_card.view.*

class CreditCardAdapter(private val callback : OnCreditCardClick,
                        private val creditCardList: List<CreditCard>) : RecyclerView.Adapter<CreditCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_credit_card,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val finalPosition = holder.adapterPosition
        holder.txtCreditCard.text = creditCardList[finalPosition].name
        Glide.with(holder.itemView).load(creditCardList[finalPosition].thumbnail).into(holder.ivCreditCard)
        holder.container.setOnClickListener { callback.onItemClick(creditCardList[finalPosition]) }

    }

    override fun getItemCount(): Int {
        return creditCardList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val container = itemView
            val txtCreditCard = itemView.txt_credit_card!!
            val ivCreditCard = itemView.iv_credit_card!!
    }
}
