package com.inbergmarcano.mycvapp.ui.knowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.inbergmarcano.mycvapp.R

class ShareFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_knowledge, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)

        return root
    }
}