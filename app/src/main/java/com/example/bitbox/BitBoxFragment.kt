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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBitBoxBinding.inflate(inflater, container, false)
        val view = binding.root
        //GridLayoutManager(activity, 3).apply { binding.recyclerView.layoutManager = this }
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class SoundHolder(mBinding: ListItemSoundBinding, itemView: View): RecyclerView.ViewHolder(
        itemView
    ) {

    }
}
