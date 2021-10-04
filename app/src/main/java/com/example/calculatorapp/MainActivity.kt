package com.example.calculatorapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    //declaration
    lateinit var display: TextView
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button
    lateinit var plus: Button
    lateinit var minus: Button
    lateinit var multiplay: Button
    lateinit var div: Button
    lateinit var equal: Button
    lateinit var delete: Button
    lateinit var clear: Button
    lateinit var sign: Button
    lateinit var result: Button
    lateinit var decimal: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        //display text
        display = findViewById(R.id.DisplayId)
        display.text = viewModel.distext

        //numbers
        zero = findViewById(R.id.but0)
        zero.setOnClickListener { viewModel.decNum('0'); display.text = viewModel.distext }
        one = findViewById(R.id.but1)
        one.setOnClickListener { viewModel.decNum('1'); display.text = viewModel.distext }
        two = findViewById(R.id.but2)
        two.setOnClickListener { viewModel.decNum('2'); display.text = viewModel.distext }
        three = findViewById(R.id.but3)
        three.setOnClickListener { viewModel.decNum('3'); display.text = viewModel.distext }
        four = findViewById(R.id.but4)
        four.setOnClickListener { viewModel.decNum('4'); display.text = viewModel.distext }
        five = findViewById(R.id.but5)
        five.setOnClickListener { viewModel.decNum('5'); display.text = viewModel.distext }
        six = findViewById(R.id.but6)
        six.setOnClickListener { viewModel.decNum('6'); display.text = viewModel.distext }
        seven = findViewById(R.id.but7)
        seven.setOnClickListener { viewModel.decNum('7'); display.text = viewModel.distext }
        eight = findViewById(R.id.but8)
        eight.setOnClickListener { viewModel.decNum('8'); display.text = viewModel.distext }
        nine = findViewById(R.id.but9)
        nine.setOnClickListener { viewModel.decNum('9'); display.text = viewModel.distext }

        //the operation
        plus = findViewById(R.id.plusBut)
        plus.setOnClickListener { viewModel.handleOperator('+'); display.text = viewModel.distext }
        minus = findViewById(R.id.minusBut)
        minus.setOnClickListener { viewModel.handleOperator('-'); display.text = viewModel.distext }
        multiplay = findViewById(R.id.multiplyBut)
        multiplay.setOnClickListener {
            viewModel.handleOperator('*'); display.text = viewModel.distext
        }
        div = findViewById(R.id.divBut)
        div.setOnClickListener { viewModel.handleOperator('/'); display.text = viewModel.distext }

        //decimal numbers
        decimal = findViewById(R.id.decimalBut)
        decimal.setOnClickListener { viewModel.onClickDecimal(); display.text = viewModel.distext }

        //sign numbers
        sign = findViewById(R.id.negativeBut)
        sign.setOnClickListener { viewModel.onClickPlusMinus(); display.text = viewModel.distext }

        //clear, result and delete
        clear = findViewById(R.id.clearBut)
        clear.setOnClickListener { viewModel.clearAll(); display.text = viewModel.distext }
        result = findViewById(R.id.equalBut)
        result.setOnClickListener { viewModel.calculate(); display.text = viewModel.distext }
        delete = findViewById(R.id.deleletBut)
        delete.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.distext }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            display.setPadding(0, 0, 24, 0)
            display.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            display.setPadding(0, 24, 24, 0)
            display.textSize = 32f
        }
    }
}