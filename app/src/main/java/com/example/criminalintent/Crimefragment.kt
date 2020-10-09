package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Crimefragment:Fragment() {
     lateinit var crime: Crime
    lateinit var textFild:TextView
    lateinit var dataButton:Button
    lateinit var slovedCheckBox:CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime= Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
        val view=inflater.inflate(R.layout.fragment_crime,container,false)
        textFild=view.findViewById(R.id.crime_title)
        dataButton=view.findViewById(R.id.crime_data)
        slovedCheckBox=view.findViewById(R.id.crime_solved)
        dataButton.apply {
            text=crime.data.toString()
            crime.isSolved=false
        }
        slovedCheckBox.apply {
            setOnClickListener{
                crime.isSolved=isChecked
            }
        }
         return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher=object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    crime.title=s.toString()
            }

        }
       textFild.addTextChangedListener(titleWatcher)
    }
}

