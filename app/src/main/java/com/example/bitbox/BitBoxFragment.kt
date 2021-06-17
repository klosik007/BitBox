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
    companion object{
        fun newInstance(): BitBoxFragment{
            return BitBoxFragment()
        }
    }

    private var _binding: FragmentBitBoxBinding? = null
    private val binding get() = _binding!!

    private var mBitBox: BitBox? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBitBoxBinding.inflate(inflater, container, false)
        val view = binding.root
        //GridLayoutManager(activity, 3).apply { binding.recyclerView.layoutManager = this }
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        binding.recyclerView.adapter = mBitBox?.let { SoundAdapter(it.sounds) }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBitBox = activity?.let { BitBox(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class SoundHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private lateinit var mBinding: ListItemSoundBinding
        init{
            //mBinding.
        }
    }

    private class SoundAdapter(private val sounds: List<Sound>) : RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflatedView = LayoutInflater.from(parent.context)
                                             .inflate(R.layout.list_item_sound, parent, false)
            return SoundHolder(inflatedView)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return sounds.size
        }
    }
}
