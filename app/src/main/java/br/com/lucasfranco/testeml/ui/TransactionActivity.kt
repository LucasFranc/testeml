package br.com.lucasfranco.testeml.ui

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.presenter.TransactionActivityPresenterImpl
import br.com.lucasfranco.testeml.utils.DialogLoading
import br.com.lucasfranco.testeml.utils.addFragment
import br.com.lucasfranco.testeml.utils.replaceFragment
import kotlinx.android.synthetic.main.main_activity.*

class TransactionActivity : AppCompatActivity() {

    var transaction : Transaction = Transaction()
    private var amountFragment = AmountFragment()
    private val creditCardFragment = CreditCardFragment()
    private val cardIssuerFragment = CardIssuerFragment()
    private val installmentFragment = InstallmentFragment()
    private val presenter = TransactionActivityPresenterImpl()
    private lateinit var loadingDialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        loadingDialog = DialogLoading().bind(this)
        bindToolbar()
        addFragment(amountFragment,R.id.container)
    }

    fun nextFragment(){
        when {
            amountFragment.isVisible -> replaceFragment(creditCardFragment)
            creditCardFragment.isVisible -> replaceFragment(cardIssuerFragment)
            cardIssuerFragment.isVisible -> replaceFragment(installmentFragment)
            installmentFragment.isVisible -> {
                showResume()
                amountFragment = AmountFragment()
                replaceFragment(amountFragment)
            }
        }
    }

    private fun bindToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    fun setToolbarTitle(title : String){
        toolbar.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            if(amountFragment.isVisible){finish()}
            else supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showResume() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.resume))
        builder.setMessage(presenter.formatMessage(transaction))
        builder.setPositiveButton(getString(R.string.ok)) { dialog, _ ->  dialog.dismiss()}
        builder.create().show()
    }

    fun showLoading(){loadingDialog.show()}
    fun hideLoading(){loadingDialog.dismiss()}
    fun showToast(message : String) {Toast.makeText(this,message,Toast.LENGTH_SHORT).show()}

    override fun onBackPressed() {
        if(amountFragment.isVisible){finish()}
        else super.onBackPressed()
    }
}