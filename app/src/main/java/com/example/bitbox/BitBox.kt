package com.example.bitbox

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

class BitBox(context: Context) {
    private val TAG: String = "BitBox"
    private val SOUNDS_FOLDER = "sample_sounds"
    private val MAX_SOUNDS = 5
    private var assets: AssetManager = context.assets
    val sounds = arrayListOf<Sound>()
    var soundPool: SoundPool.Builder = SoundPool.Builder()
    var soundPoolInit = soundPool.build()

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
            try{
                val assetPath = "$SOUNDS_FOLDER/$soundName"
                val sound = Sound(assetPath)
                load(sound)
                sounds.add(sound)
            }catch (e: IOException){
                Log.e(TAG, "Cannot load file ${soundName}", e)
            }
        }
    }

    private fun load(sound: Sound){
        val afd: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId: Int = soundPoolInit.load(afd, 1)
        sound.soundId = soundId
    }

    fun play(sound: Sound){
        val soundId: Int? = sound.soundId

        if (soundId != null) {
            soundPoolInit.play(soundId, 1.0f, 1.0f, 0, 1, 1.0f)
        }

    }
}