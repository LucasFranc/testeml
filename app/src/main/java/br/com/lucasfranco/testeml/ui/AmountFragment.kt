package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenter
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_amount.view.*
import java.util.*

class AmountFragment : Fragment() {

    private var presenter: AmountFragmentPresenter = AmountFragmentPresenter()
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_amount,container,false)
        bindEdtValue()
        bindBtnNext()
        return rootView
    }

    private fun bindEdtValue() {
        rootView.edt_text_value.locale = Locale.US

    }

    private fun bindBtnNext() {
        rootView.btn_next.setOnClickListener {
            if (!presenter.checkZero(edt_text_value.rawValue))
                presenter.onClickBtnNext(presenter.formatValue(edt_text_value.text.toString()))
            else
                showError()
        }
    }

    private fun showError() {
        edt_text_value.error = getString(R.string.error_zero)
    }
}
