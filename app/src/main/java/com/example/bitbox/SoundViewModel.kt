package com.example.bitbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(var bitbox: BitBox): BaseObservable(){
    private var sound: Sound? = null

    @Bindable
    @JvmName("getTitle1")
    fun getTitle(): String{
        return sound!!.name
    }

    fun getSound(): Sound? {
        return sound
    }

    fun setSound(sound: Sound?) {
        this.sound = sound
        notifyChange()
    }

    fun onButtonClicked() {
        bitbox.play(sound!!)
    }
}