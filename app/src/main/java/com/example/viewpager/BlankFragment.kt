package com.example.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.viewpager.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding

    val imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(layoutInflater)

        fillCollection()
        initAdapter()

        return binding.root
    }

    private fun fillCollection(){
        imageList.add(R.mipmap.candy)
        imageList.add(R.mipmap.car)
        imageList.add(R.mipmap.ferrari)
        imageList.add(R.mipmap.porsche)
        imageList.add(R.mipmap.pumpkin)
        imageList.add(R.mipmap.profile)
    }

    private fun initAdapter(){
        val adapter = ImageViewPagerAdapter(imageList, object :ItemListener{
            override fun onImageClick(position: Int) {
                findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToSecondFragment(imageList[position]))

            }

        })
        binding.viewPager.adapter = adapter
    }
}