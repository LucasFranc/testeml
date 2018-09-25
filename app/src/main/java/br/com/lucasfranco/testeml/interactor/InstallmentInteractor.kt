package br.com.lucasfranco.testeml.interactor

import br.com.lucasfranco.testeml.Constants
import br.com.lucasfranco.testeml.RetrofitClient
import br.com.lucasfranco.testeml.model.Installments
import br.com.lucasfranco.testeml.service.InstallmentService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstallmentInteractor {

    fun doRequestInstallments(amount: String, CCid: String, CIid: String,
                              callback: (installments : Installments) -> Unit) {
        RetrofitClient.getClient().create(InstallmentService::class.java).getAllInstallments(
                Constants.PUBLIC_KEY_VALUE,
                amount,
                CCid,
                CIid).
                enqueue(object : Callback<List<Installments>> {

                    override fun onResponse(call: Call<List<Installments>>, response: Response<List<Installments>>) {
                        if(response.isSuccessful){
                            val selectedInstallment = response.body()!!.filter{ it.issuer.id == CIid }
                            callback(selectedInstallment.single())
                        }
                    }

                    override fun onFailure(call: Call<List<Installments>>, t: Throwable) {
                        t.printStackTrace()
                    }


                })
    }
}
