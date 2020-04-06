package com.itacademy.covid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private var resultType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultType = intent.getIntExtra("resultType", 0)
        setContentView(R.layout.activity_result)
        setUpUi(resultType)
    }


    private fun setUpUi(resultType: Int) {
        mainBackground.background = getDrawable(ViewModel.getResultBackgroundImage(resultType))

        firstTitle.text = getString(ViewModel.getResultFirstTitle(resultType))
        firstTitle.setTextColor(getColor(ViewModel.getResultColor(resultType)))
        separatorView.background = getDrawable(ViewModel.getSeparatorBackground(resultType))

        secondTitle.text = getString(ViewModel.getResultSecondTitle(resultType))
        secondTitle.setTextColor(getColor(ViewModel.getResultColor(resultType)))

        resultText.text = (Html.fromHtml(getString(ViewModel.getResultText(resultType))))
        startTestAgain.setImageResource(ViewModel.getResultReloadImage(resultType))


        startTestAgain.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
