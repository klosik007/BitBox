package com.example.bitbox

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.IOException

class BitBox(context: Context) {
    private val TAG: String = "BitBox"
    private val SOUNDS_FOLDER = "sample_sounds"
    private var assets: AssetManager = context.assets
    val sounds = arrayListOf<Sound>()

    init {
        loadSounds()
    }

    private fun loadSounds(){
        var soundNames = arrayOf<String>()

        try{
            soundNames = assets.list(SOUNDS_FOLDER) as Array<String> //list - show file names in directory
            Log.i(TAG, "Found ${soundNames.size} sounds")
        }catch(e: IOException){
            Log.e(TAG, "Cannot show sounds list", e)
        }

        for(soundName in soundNames){
            val assetPath = "$SOUNDS_FOLDER/$soundName"
            val sound = Sound(assetPath)
            sounds.add(sound)
        }
    }
}