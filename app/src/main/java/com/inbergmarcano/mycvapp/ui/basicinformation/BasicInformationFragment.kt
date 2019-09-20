package com.inbergmarcano.mycvapp.ui.basicinformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.inbergmarcano.mycvapp.R

class BasicInformationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_basic_information, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        return root
    }
}