package com.example.bitbox

class Sound(assetPath: String) {
    private var _assetPath: String = assetPath
    private var _name: String

    init{
        val components = _assetPath.split("/")
        val fileName = components[components.size - 1]
        _name = fileName.replace(".wav", "")
    }
}