package com.example.lab2_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import javax.crypto.Mac


class MainActivity : AppCompatActivity() {
    private lateinit var priority_check: Spinner
    private lateinit var Mid:EditText
    private lateinit var Mac_check:CheckBox
    private lateinit var Win_check: CheckBox
    private lateinit var device_number: EditText
    private lateinit var Summary : TextView
    private lateinit var resultbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initializing the views
        Summary = findViewById(R.id.result)
        Mid = findViewById(R.id.Studentid)
        Mac_check = findViewById(R.id.macos)
        Win_check = findViewById(R.id.winos)
        device_number = findViewById(R.id.devNum)
        Mac_check.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Win_check.isChecked = false //condition to check only one box
            } else {
                Win_check.isEnabled = true

            }
        }

        Win_check.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Mac_check.isChecked = false //condition to check only one box
            } else {
                Mac_check.isEnabled = true

            }


        }


        priority_check = findViewById(R.id.priority_check)
        resultbtn = findViewById(R.id.check_button)
        resultbtn.setOnClickListener {
            displayResults()

        }
    }


    private fun displayResults(){
        val enteredText=Mid.text.toString()
        val selectedOption=priority_check.selectedItem.toString()
        val enteredInteger=device_number.text.toString()
        val selectedRadio=if(Mac_check.isChecked) "MacOS" else "Windows"


        val Summary_text= """"
            Priority : $selectedOption
            School Id: $enteredText
            $selectedRadio
            Device Number: $enteredInteger
        """.trimIndent()

        Summary.text=Summary_text

    }


}