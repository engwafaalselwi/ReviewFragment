package com.example.reviewfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {
    private lateinit var ColorTextView: TextView
    private lateinit var ColorButton: Button
    interface Callbacks{
        fun onClick(Colorfrag : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    private var callbacks : Callbacks? = null

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object{
        fun newInstance(color : String):ColorFragment{
            val args = Bundle().apply {
                putSerializable("Color",color)
            }
            return ColorFragment().apply {
                arguments = args
            }
        }
    }
    var ColorName : String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ColorName = arguments?.getSerializable("Color") as String

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_color_fragement,container,false)
        ColorTextView = view.findViewById(R.id.ColorTextView)as TextView
        ColorButton = view.findViewById(R.id.ColorButton)as Button
        ColorTextView.setText(ColorName)
        ColorButton.setOnClickListener {
            callbacks?.onClick("This is The Fragment1 in to Fragment2")

        }
        return view
    }
}