package com.d3if4119.modul05.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.d3if4119.modul05.R
import com.d3if4119.modul05.data.KategoriBmi
import com.d3if4119.modul05.databinding.FragmentSaranBinding

class SaranFragment : Fragment() {
    private val args: SaranFragmentArgs by navArgs()
    private lateinit var binding: FragmentSaranBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(
                layoutInflater, container, false)
        updateUI(args.kategori)
        return binding.root
    }

    private fun updateUI(kategori: KategoriBmi) {
        val actionBar = (requireActivity() as AppCompatActivity)
                .supportActionBar
        when (kategori) {
            KategoriBmi.KURUS -> {
                actionBar?.title = getString(R.string.judul_kurus)
                binding.imageView.setImageResource(R.drawable.kurus)
                binding.textView.text = getString(R.string.saran_kurus)
            }
            KategoriBmi.IDEAL -> {
                actionBar?.title = getString(R.string.judul_ideal)
                binding.imageView.setImageResource(R.drawable.ideal)
                binding.textView.text = getString(R.string.saran_ideal)
            }
            KategoriBmi.GEMUK -> {
                actionBar?.title = getString(R.string.judul_gemuk)
                binding.imageView.setImageResource(R.drawable.gemuk)
                binding.textView.text = getString(R.string.saran_gemuk)
            }
        }
    }
}