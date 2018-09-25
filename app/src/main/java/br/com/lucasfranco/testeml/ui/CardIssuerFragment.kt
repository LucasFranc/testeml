package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnCardIssuerClick
import br.com.lucasfranco.testeml.model.CardIssuer
import br.com.lucasfranco.testeml.presenter.CardIssuerFragmentPresenterImpl
import br.com.lucasfranco.testeml.ui.adapter.CardIssuerAdapter
import br.com.lucasfranco.testeml.view.CardIssuerFragmentView
import kotlinx.android.synthetic.main.fragment_card_issuer.view.*

class CardIssuerFragment : Fragment(), CardIssuerFragmentView, OnCardIssuerClick {

    private lateinit var rootView: View
    private var presenter = CardIssuerFragmentPresenterImpl()
    private lateinit var act : TransactionActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_card_issuer,container,false)
        act = requireActivity() as TransactionActivity
        presenter.attachView(this)
        presenter.doRequestCardIssuers(act.transaction)
        return rootView
    }

    override fun updateRecyclerView(list: List<CardIssuer>) {
        rootView.rv_card_issuer.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        rootView.rv_card_issuer.adapter = CardIssuerAdapter(this,list)
    }

    override fun onItemClick(selectedItem: CardIssuer) {
        act.transaction.selectedCI = selectedItem
        act.nextFragment()
    }

}