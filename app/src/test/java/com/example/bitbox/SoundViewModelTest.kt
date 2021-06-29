package com.example.bitbox

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.isA
import com.natpryce.hamkrest.startsWith
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SoundViewModelTest {
    private lateinit var bitbox: BitBox
    private lateinit var sound: Sound
    private lateinit var subjectSVM: SoundViewModel

    @Before
    fun setUp() {
        bitbox = mock()
        sound = Sound("assetPath")
        subjectSVM = SoundViewModel(bitbox)
        subjectSVM.setSound(sound)
    }

    @Test
    fun exposesSoundNameAsTitle(){
        com.natpryce.hamkrest.assertion.assertThat(subjectSVM.getTitle(), isA(Matcher(String::equals)(sound.name)))
    }

    @Test
    fun onButtonClickedCallsBitBoxPlayButton(){
        subjectSVM.onButtonClicked()
        verify(bitbox).play(sound)
    }
}