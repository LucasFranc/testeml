package br.com.lucasfranco.testeml.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnCardIssuerClick
import br.com.lucasfranco.testeml.model.CardIssuer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_card_issuer.view.*

class CardIssuerAdapter(private val callback: OnCardIssuerClick,
                        private val cardIssuerList: List<CardIssuer>) : RecyclerView.Adapter<CardIssuerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_card_issuer,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val finalPosition = holder.adapterPosition
        holder.txtCardIssuer.text = cardIssuerList[finalPosition].name
        Glide.with(holder.itemView).load(cardIssuerList[finalPosition].thumbnail).into(holder.ivCardIssuer)
        holder.container.setOnClickListener { callback.onItemClick(cardIssuerList[finalPosition]) }

    }

    override fun getItemCount(): Int {
        return cardIssuerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container = itemView
        val txtCardIssuer = itemView.txt_card_issuer!!
        val ivCardIssuer = itemView.iv_card_issuer!!
    }

}
