package br.com.lucasfranco.testeml.service

import br.com.lucasfranco.testeml.Constants
import br.com.lucasfranco.testeml.model.Installments
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InstallmentService {

    @GET(Constants.PAYMENT_METHODS + Constants.INSTALLMENTS)
    fun getAllInstallments(@Query("public_key") publicKey: String,
                           @Query("amount") amount: String,
                           @Query("payment_method_id") paymentId : String,
                           @Query("issuer_id") issuerId : String) : Call<List<Installments>>

}