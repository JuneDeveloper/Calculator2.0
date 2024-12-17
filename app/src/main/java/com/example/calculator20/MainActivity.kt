package com.example.calculator20

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var one = ""
    private var two = ""
    private var action = ""

    private lateinit var toolbarTB: Toolbar

    private lateinit var inputTextET: EditText
    private lateinit var outputTextTV: TextView

    private lateinit var buttonOneBTN: Button
    private lateinit var buttonTwoBTN: Button
    private lateinit var buttonThreeBTN: Button
    private lateinit var buttonFourBTN: Button
    private lateinit var buttonFiveBTN: Button
    private lateinit var buttonSixBTN: Button
    private lateinit var buttonSevenBTN: Button
    private lateinit var buttonEightBTN: Button
    private lateinit var buttonNineBTN: Button
    private lateinit var buttonZeroBTN: Button

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonMultBTN: Button
    private lateinit var buttonDivBTN: Button

    private lateinit var buttonResultBTN: Button
    private lateinit var buttonResetBTN: Button

    @SuppressLint("MissingInflatedId", "ResourceAsColor", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        outputTextTV = findViewById(R.id.outputTextTV)
        inputTextET = findViewById(R.id.inputTextET)
        inputTextET.isEnabled = false

        buttonOneBTN = findViewById(R.id.buttonOneBTN)
        buttonTwoBTN = findViewById(R.id.buttonTwoBTN)
        buttonThreeBTN = findViewById(R.id.buttonThreeBTN)
        buttonFourBTN = findViewById(R.id.buttonFourBTN)
        buttonFiveBTN = findViewById(R.id.buttonFiveBTN)
        buttonSixBTN = findViewById(R.id.buttonSixBTN)
        buttonSevenBTN = findViewById(R.id.buttonSevenBTN)
        buttonEightBTN = findViewById(R.id.buttonEightBTN)
        buttonNineBTN = findViewById(R.id.buttonNineBTN)
        buttonZeroBTN = findViewById(R.id.buttonZeroBTN)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonMultBTN = findViewById(R.id.buttonMultBTN)
        buttonDivBTN = findViewById(R.id.buttonDivBTN)

        buttonResultBTN = findViewById(R.id.buttonResultBTN)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)

        buttonOneBTN.setOnClickListener(this)
        buttonTwoBTN.setOnClickListener(this)
        buttonThreeBTN.setOnClickListener(this)
        buttonFourBTN.setOnClickListener(this)
        buttonFiveBTN.setOnClickListener(this)
        buttonSixBTN.setOnClickListener(this)
        buttonSevenBTN.setOnClickListener(this)
        buttonEightBTN.setOnClickListener(this)
        buttonNineBTN.setOnClickListener(this)
        buttonZeroBTN.setOnClickListener(this)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        buttonMultBTN.setOnClickListener(this)
        buttonDivBTN.setOnClickListener(this)

        buttonResultBTN.setOnClickListener(this)
        buttonResetBTN.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMain -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        if (action.isEmpty()) {
            when (v.id) {
                R.id.buttonOneBTN -> one += "1"
                R.id.buttonTwoBTN -> one += "2"
                R.id.buttonThreeBTN -> one += "3"
                R.id.buttonFourBTN -> one += "4"
                R.id.buttonFiveBTN -> one += "5"
                R.id.buttonSixBTN -> one += "6"
                R.id.buttonSevenBTN -> one += "7"
                R.id.buttonEightBTN -> one += "8"
                R.id.buttonNineBTN -> one += "9"
                R.id.buttonZeroBTN -> one += "0"
                R.id.buttonSumBTN -> action = "+"
                R.id.buttonDifBTN -> action = "-"
                R.id.buttonMultBTN -> action = "*"
                R.id.buttonDivBTN -> action = "/"
            }
        } else {
            when (v.id) {
                R.id.buttonOneBTN -> two += "1"
                R.id.buttonTwoBTN -> two += "2"
                R.id.buttonThreeBTN -> two += "3"
                R.id.buttonFourBTN -> two += "4"
                R.id.buttonFiveBTN -> two += "5"
                R.id.buttonSixBTN -> two += "6"
                R.id.buttonSevenBTN -> two += "7"
                R.id.buttonEightBTN -> two += "8"
                R.id.buttonNineBTN -> two += "9"
                R.id.buttonZeroBTN -> two += "0"
            }
        }
        inputTextET.setText("$one$action$two=")

        when (v.id) {
            R.id.buttonResultBTN -> {
                val result = when (action) {
                    "+" -> Operation(one, two).sum()
                    "-" -> Operation(one, two).dif()
                    "*" -> Operation(one, two).mult()
                    "/" -> Operation(one, two).div()
                    else -> 0
                }
                outputTextTV.text = result.toString()
            }
            R.id.buttonResetBTN -> {
                inputTextET.text.clear()
                outputTextTV.text = ""
                one = ""
                two = ""
                action = ""
            }
        }
    }
}







