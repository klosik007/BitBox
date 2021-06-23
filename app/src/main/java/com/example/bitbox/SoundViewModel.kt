package com.example.bitbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(bitbox: BitBox): BaseObservable(){
    private var _bitBox: BitBox = bitbox
    var sound: Sound = Sound("")
        set(value){
            field = value
            notifyChange()
        }

    @Bindable
    var title: String = sound.name
}