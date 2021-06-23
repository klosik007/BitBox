package com.example.bitbox

class Sound(assetPath: String) {
    private var _assetPath: String = assetPath
    var name: String

    init{
        val components = _assetPath.split("/")
        val fileName = components[components.size - 1]
        name = fileName.replace(".wav", "")
    }
}