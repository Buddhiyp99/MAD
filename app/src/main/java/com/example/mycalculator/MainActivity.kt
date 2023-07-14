package com.example.mycalculator






import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var displayTextView: TextView
    private var operand1: Double = 0.0
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayTextView = findViewById(R.id.displayTextView)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        val number = button.text.toString()
        val currentText = displayTextView.text.toString()

        if (currentText == "0") {
            displayTextView.text = number
        } else {
            displayTextView.append(number)
        }
    }

    fun onOperatorClick(view: View) {
        val button = view as Button
        operator = button.text.toString()
        operand1 = displayTextView.text.toString().toDouble()
        displayTextView.text = "0"
    }




    fun onAllClearClick(view: View) {
        displayTextView.text = "0"
        operand1 = 0.0
        operator = null
    }

    fun onEqualClick(view: View) {
        val operand2 = displayTextView.text.toString().toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> {
                if (operand2 != 0.0) {
                    result = operand1 / operand2
                } else {
                    displayTextView.text = "Error"
                    return
                }
            }
        }

        displayTextView.text = result.toString()
    }








}
