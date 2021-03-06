package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnCreditCardClick
import br.com.lucasfranco.testeml.model.CreditCard
import br.com.lucasfranco.testeml.presenter.CreditCardFragmentPresenterImpl
import br.com.lucasfranco.testeml.ui.adapter.CreditCardAdapter
import br.com.lucasfranco.testeml.view.CreditCardFragmentView
import kotlinx.android.synthetic.main.fragment_credit_card.view.*

class CreditCardFragment : Fragment(), OnCreditCardClick, CreditCardFragmentView {

    private lateinit var rootView: View
    private var presenter = CreditCardFragmentPresenterImpl()
    private lateinit var act : TransactionActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_credit_card,container,false)
        act = requireActivity() as TransactionActivity
        act.setToolbarTitle(resources.getString(R.string.credit_card))
        presenter.attachView(this)
        presenter.doRequestCreditCards()
        return rootView
    }

    override fun updateRecyclerView(list: List<CreditCard>) {
        rootView.rv_credit_card.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rootView.rv_credit_card.adapter = CreditCardAdapter(this,list)
    }

    override fun onItemClick(selectedItem: CreditCard) {
        act.transaction.selectedCC = selectedItem
        act.nextFragment()
    }

    override fun showLoading() { act.showLoading() }
    override fun hideLoading() { act.hideLoading() }
    override fun showToast(message : String) {act.showToast(message)}

}