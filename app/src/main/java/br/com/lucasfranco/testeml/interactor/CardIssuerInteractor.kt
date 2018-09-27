package br.com.lucasfranco.testeml.interactor

import br.com.lucasfranco.testeml.model.CardIssuer
import br.com.lucasfranco.testeml.service.CardIssuerService
import br.com.lucasfranco.testeml.utils.Constants
import br.com.lucasfranco.testeml.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardIssuerInteractor {

    fun doRequestCardIssuers(cardIssuerId : String,
                             callBackSuccess: (List<CardIssuer>) -> Unit,
                             callbackError: (String) -> Unit){
        RetrofitClient.getClient().create(CardIssuerService::class.java).getAllCardIssuers(Constants.PUBLIC_KEY_VALUE,cardIssuerId).
                enqueue(object : Callback<List<CardIssuer>> {
                    override fun onResponse(call: Call<List<CardIssuer>>, response: Response<List<CardIssuer>>) {
                        if(response.isSuccessful){
                            callBackSuccess(response.body()!!)
                        }else
                            onFailure(call,Throwable("error"))
                    }
                    override fun onFailure(call: Call<List<CardIssuer>>, t: Throwable) {
                        callbackError(t.localizedMessage)
                    }
                })
    }

}
