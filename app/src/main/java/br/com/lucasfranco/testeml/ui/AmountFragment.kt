package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenterImpl
import br.com.lucasfranco.testeml.view.AmountFragmentView
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_amount.view.*
import java.util.*

class AmountFragment : Fragment(), AmountFragmentView {

    private val presenter = AmountFragmentPresenterImpl()
    private lateinit var rootView: View
    private lateinit var act: TransactionActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_amount, container, false)
        presenter.attachView(this)
        act = requireActivity() as TransactionActivity
        act.setToolbarTitle(resources.getString(R.string.amount))
        bindEdtValue()
        bindBtnNext()
        return rootView
    }

    private fun bindEdtValue() {
        rootView.edt_text_amount.locale = Locale.US
    }

    private fun bindBtnNext() {
        rootView.btn_next.setOnClickListener {
                presenter.onClickBtnNext(
                        edt_text_amount.rawValue,
                        act.transaction,
                        edt_text_amount.text.toString())
        }
    }

    override fun showError() {
        txt_input_amount.error = getString(R.string.error_zero)
    }

    override fun onNextFragment() {
        act.nextFragment()
    }
}
