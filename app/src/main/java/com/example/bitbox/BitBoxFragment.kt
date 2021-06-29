package com.example.bitbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitbox.databinding.FragmentBitBoxBinding
import com.example.bitbox.databinding.ListItemSoundBinding

class BitBoxFragment : Fragment() {
    private var _binding: FragmentBitBoxBinding? = null
    private val binding get() = _binding!!

    private var mBitBox: BitBox? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBitBoxBinding.inflate(inflater, container, false)
        val view = binding.root
        mBitBox = context?.let { BitBox(it) }
        //GridLayoutManager(activity, 3).apply { binding.recyclerView.layoutManager = this }
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        binding.recyclerView.adapter = SoundAdapter(mBitBox!!.sounds)
        retainInstance
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        mBitBox?.clearMemoryFromSounds()
    }

    private class SoundHolder(private val itemBinding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        val bitbox = BitBox(itemBinding.root.context)

        init{
            itemBinding.viewModel = SoundViewModel(bitbox)
        }

        fun bindSounds(sound: Sound){
            itemBinding.viewModel!!.setSound(sound)
            itemBinding.executePendingBindings()
        }
    }

    private class SoundAdapter(private val sounds: List<Sound>) : RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflatedView = ListItemSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SoundHolder(inflatedView)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound: Sound = sounds[position]
            holder.bindSounds(sound)
        }

        override fun getItemCount(): Int {
            return sounds.size
        }
    }
}
