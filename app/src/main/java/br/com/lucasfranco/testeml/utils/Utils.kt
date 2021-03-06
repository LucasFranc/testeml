package br.com.lucasfranco.testeml.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import br.com.lucasfranco.testeml.R

inline fun FragmentManager.transaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            .func()
            .commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.transaction { replace(R.id.container, fragment).addToBackStack(null) }
}