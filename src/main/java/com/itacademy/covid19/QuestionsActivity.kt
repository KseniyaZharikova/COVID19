package com.itacademy.covid19

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    private var questionType: Int = 0
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setUpUi(questionType)
    }

    private fun setUpUi(questionType: Int) {
        when (questionType) {
            ViewModel.QuestionType.contact -> {
                buttonLayout1.visibility = View.GONE
                buttonLayout2.visibility = View.VISIBLE
                buttonLayout3.visibility = View.VISIBLE
            }

            else -> {
                buttonLayout1.visibility = View.VISIBLE
                buttonLayout2.visibility = View.GONE
                buttonLayout3.visibility = View.GONE
            }
        }

        questionNumber.text = ViewModel.getEnumerationText(questionType)
        questionText.text = getString(ViewModel.getQuestionText(questionType))

        yesButton.setOnClickListener {
            saveQuestion(true)
        }

        noButton.setOnClickListener {
            saveQuestion(false)
        }


        zero.setOnClickListener {
            saveNumberOfContacts("0")
        }

        oneToFive.setOnClickListener {
            saveNumberOfContacts("1-5")
        }

        fiveToTen.setOnClickListener {
            saveNumberOfContacts("5-10")
        }

        tenToFifteen.setOnClickListener {
            saveNumberOfContacts("10-15")
        }
    }

    private fun saveNumberOfContacts(number: String) {
        when (number) {
            "1-5" -> {
                points += 10
            }
            "5-10" -> {
                points += 20
            }
            "10-15" -> {
                points += 25
            }
        }
        questionType = ViewModel.QuestionType.contactOthers
        setUpUi(questionType)
    }

    private fun saveQuestion(yes: Boolean) {
        when (questionType) {

            ViewModel.QuestionType.immunity -> {
                points = if (yes) points + 12 else points
                questionType = ViewModel.QuestionType.diseases
                setUpUi(questionType)
            }

            ViewModel.QuestionType.diseases -> {
                points = if (yes) points + 12 else points
                questionType = ViewModel.QuestionType.contact
                setUpUi(questionType)
            }

            ViewModel.QuestionType.contactOthers -> {
                points = if (yes) points + 25 else points
                questionType = ViewModel.QuestionType.remedies
                setUpUi(questionType)
            }

            ViewModel.QuestionType.remedies -> {
                points = if (!yes) points + 13 else points
                questionType = ViewModel.QuestionType.quarantine
                setUpUi(questionType)
            }

            ViewModel.QuestionType.quarantine -> {
                points = if (!yes) points + 13 else points
                calculateResult()
            }

            else -> {
            }
        }
    }

    private fun calculateResult() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("resultType", getResultType(points))
        startActivity(intent)
    }

    private fun getResultType(points: Int): Int {
        return when {
            points < 10 -> {
                 ViewModel.ResultType.veryLow
            }
            points < 30 -> {
                 ViewModel.ResultType.low
            }
            points < 50 -> {
                ViewModel.ResultType.average

            }
            points < 70 -> {
                ViewModel.ResultType.high

            }
            points < 100 -> {
                ViewModel.ResultType.veryHigh
            }
            else -> {
                ViewModel.ResultType.veryLow
            }
        }
    }
}