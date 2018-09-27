package br.com.lucasfranco.testeml.interactor

import br.com.lucasfranco.testeml.model.CreditCard
import br.com.lucasfranco.testeml.service.CreditCardService
import br.com.lucasfranco.testeml.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreditCardInteractor {

    fun doRequestCreditCards(callBackSuccess: (List<CreditCard>) -> Unit,
                             callbackError: (String) -> Unit) {
        RetrofitClient.getClient().create(CreditCardService::class.java).getAllCreditCards().
                enqueue(object : Callback<List<CreditCard>>{

                    override fun onResponse(call: Call<List<CreditCard>>, response: Response<List<CreditCard>>) {
                        if(response.isSuccessful){
                            callBackSuccess(response.body()!!)
                        }else
                            onFailure(call,Throwable("error"))

                    }

                    override fun onFailure(call: Call<List<CreditCard>>, t: Throwable) {
                        callbackError(t.localizedMessage)
                    }


                })
    }

}