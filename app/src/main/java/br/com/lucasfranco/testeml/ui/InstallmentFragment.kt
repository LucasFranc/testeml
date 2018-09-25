package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.callback.OnInstallmentClick
import br.com.lucasfranco.testeml.model.Installment
import br.com.lucasfranco.testeml.model.Installments
import br.com.lucasfranco.testeml.presenter.InstallmentFragmentPresenterImpl
import br.com.lucasfranco.testeml.view.InstallmentFragmentView

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

    override fun updateRecyclerView(list: Installments) {

    }

    override fun onItemClick(installment: Installment) {

    }

}