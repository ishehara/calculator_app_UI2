package com.example.calculator_app_ui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator_app_ui2.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.StringBuilder
import java.math.BigDecimal
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // this method is use for replacement of android-kotlin-extentions

    var currentInput = StringBuilder() //represents a mutable sequence of characters
    var currentOperator = Operator.NONE
    var operand1: BigDecimal? = null

    enum class Operator {
        NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Set click listeners for number buttons
        binding.btn1.setOnClickListener { appendNumber("1") }
        binding.btn2.setOnClickListener { appendNumber("2") }
        binding.btn3.setOnClickListener { appendNumber("3") }
        binding.btn4.setOnClickListener { appendNumber("4") }
        binding.btn5.setOnClickListener { appendNumber("5") }
        binding.btn6.setOnClickListener { appendNumber("6") }
        binding.btn7.setOnClickListener { appendNumber("7") }
        binding.btn8.setOnClickListener { appendNumber("8") }
        binding.btn9.setOnClickListener { appendNumber("9") }
        binding.btn0.setOnClickListener { appendNumber("0") }
        binding.btnDot.setOnClickListener { appendNumber(".") }
        // Set click listeners for operator buttons
        binding.btnPlus.setOnClickListener { setOperator(Operator.ADD) }
        binding.btnSubstraction.setOnClickListener { setOperator(Operator.SUBTRACT) }
        binding.btnMultify.setOnClickListener { setOperator(Operator.MULTIPLY) }
        binding.btnDivide.setOnClickListener { setOperator(Operator.DIVIDE) }
//
//        // Handle equals button click
//        binding.btnEqual.setOnClickListener { calculateResult() }
//
        // Handle clear button click
        binding.btnAC.setOnClickListener {
            allClearInput()
            updateDisplay()
        }

        //backSpace button
        binding.btnClear.setOnClickListener { handleBackspace() }

   }

    private fun appendNumber(number: String) {
        currentInput.append(number)
        updateDisplay()
    }
    private fun handleBackspace() {
        if (currentInput.isNotEmpty()) {
            currentInput.deleteCharAt(currentInput.length - 1) // deleting charactors in StringBilder fuction
            updateDisplay()
        }
    }

//    private fun setOperator(operator: Operator) {
//        if (operand1 == null) {
//            operand1 = BigDecimal(currentInput.toString())
//            currentInput.clear()
//        }
//        tvOldInput.text = operand1.toString()
//        tvInput.text = ""
//        currentOperator = operator
//        tvCurrentOperand.text = operatorToString(operator)
//    }
    private fun setOperator(operator:Operator){
        if(currentOperator==Operator.NONE){
            currentOperator = operator
        }
        currentInput.append(operatorToString(operator))
        updateDisplay()
    }





    private fun operatorToString(operator: Operator): String {
        return when (operator) {
            Operator.ADD -> "+"
            Operator.SUBTRACT -> "-"
            Operator.MULTIPLY -> "×"
            Operator.DIVIDE -> "÷"
            Operator.NONE -> ""
        }
    }
//    private fun calculateResult() {
//        val operand2 = BigDecimal(currentInput.toString())
//        var result: BigDecimal? = null
//        Log.d("CalculatorApp", "operand1= ${operand1}")
//        Log.d("CalculatorApp", "operand2= ${operand2}")
//        Log.d("CalculatorApp", "currentInput= ${currentInput.toString()}")
//
//        when (currentOperator) {
//            Operator.ADD -> result = operand1?.add(operand2)
//            Operator.SUBTRACT -> result = operand1?.subtract(operand2)
//            Operator.MULTIPLY -> result = operand1?.multiply(operand2)
//            Operator.DIVIDE -> {
//                if (operand2 != BigDecimal.ZERO) {
//                    result = operand1?.divide(operand2, 10, BigDecimal.ROUND_HALF_UP)
//                }
//            }
//            Operator.NONE -> result = operand2
//        }
//
//        // Display the result and reset the state
//        if (result != null) {
//            tvOldInput.text = ("${operand1}${operatorToString(currentOperator)}${operand2}").toString()
//            tvInput.text = result.toString()
//            operand1 = result
//        }
////        Log.d("CalculatorApp", "Result: ${result?.toString()}")
//
//    }
    private fun allClearInput() {
        currentInput.clear()            //making StringBuilder empty
        binding.outputViwer.text = ""

    }


    private fun updateDisplay() {
        binding.inputViewer.text = currentInput.toString()
    }
}

