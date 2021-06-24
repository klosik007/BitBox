package com.example.bitbox

class Sound(assetPath: String) {
    var assetPath: String = assetPath
    var name: String
    var soundId: Int? = null

    init{
        val components = assetPath.split("/")
        val fileName = components[components.size - 1]
        name = fileName.replace(".wav", "")
    }
}