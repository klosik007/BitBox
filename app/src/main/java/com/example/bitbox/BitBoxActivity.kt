package com.example.bitbox

import androidx.fragment.app.Fragment

class BitBoxActivity : SingleFragmentActivity(){
    override fun createFragment(): Fragment {
        return BitBoxFragment.newInstance()
    }
}