package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnInstallmentClick
import br.com.lucasfranco.testeml.model.Installment
import br.com.lucasfranco.testeml.model.Installments
import br.com.lucasfranco.testeml.presenter.InstallmentFragmentPresenterImpl
import br.com.lucasfranco.testeml.ui.adapter.InstallmentAdapter
import br.com.lucasfranco.testeml.view.InstallmentFragmentView
import kotlinx.android.synthetic.main.fragment_installment.view.*

class InstallmentFragment: Fragment(), OnInstallmentClick, InstallmentFragmentView {

    private lateinit var rootView: View
    private var presenter = InstallmentFragmentPresenterImpl()
    private lateinit var act : TransactionActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_installment,container,false)
        act = requireActivity() as TransactionActivity
        presenter.attachView(this)
        presenter.doRequestInstallments(act.transaction)
        return rootView
    }

    override fun updateRecyclerView(installments: Installments) {
        rootView.rv_installment.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rootView.rv_installment.adapter = InstallmentAdapter(this,installments)
    }

    override fun onItemClick(installment: Installment) {
        act.transaction.selectedInstallment = installment
        act.nextFragment()
    }

}