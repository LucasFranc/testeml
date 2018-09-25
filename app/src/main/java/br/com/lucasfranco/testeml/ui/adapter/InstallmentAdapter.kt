package br.com.lucasfranco.testeml.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnInstallmentClick
import br.com.lucasfranco.testeml.model.Installments
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_installment.view.*

class InstallmentAdapter(private val callback: OnInstallmentClick,
                         private val installments: Installments) : RecyclerView.Adapter<InstallmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_installment,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val finalPosition = holder.adapterPosition
        holder.txtInstallments.text = installments.payer_costs[finalPosition].recommended_message
        Glide.with(holder.itemView).load(installments.issuer.thumbnail).into(holder.ivInstallments)
        holder.container.setOnClickListener { callback.onItemClick(installments.payer_costs[finalPosition]) }
    }

    override fun getItemCount(): Int {
        return installments.payer_costs.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container = itemView
        val txtInstallments = itemView.txt_installment!!
        val ivInstallments = itemView.iv_installment!!
    }

}
