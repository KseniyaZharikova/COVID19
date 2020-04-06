package com.itacademy.covid19

object ViewModel {

    object QuestionType {
        const val immunity = 0
        const val diseases = 1
        const val contact = 2
        const val contactOthers = 3
        const val remedies = 4
        const val quarantine = 5
    }

    object ResultType {
        const val veryLow = 0
        const val low = 1
        const val average = 2
        const val high = 3
        const val veryHigh = 4
    }

    fun getQuestionText(type: Int): Int {
        return when (type) {
            QuestionType.immunity -> R.string.immunity
            QuestionType.diseases ->  R.string.diseases
            QuestionType.contact ->  R.string.contact
            QuestionType.contactOthers ->  R.string.contactOthers
            QuestionType.remedies -> R.string.remedies
            QuestionType.quarantine ->  R.string.quarantine
            else -> 0
        }
    }


    fun getEnumerationText(type: Int): String {
        return when (type) {
            QuestionType.immunity -> "1/6"
            QuestionType.diseases -> "2/6"
            QuestionType.contact -> "3/6"
            QuestionType.contactOthers -> "4/6"
            QuestionType.remedies -> "5/6"
            QuestionType.quarantine -> "6/6"
            else -> ""
        }
    }

    fun getResultFirstTitle(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.string.veryLowFirstTitle
            ResultType.low ->  R.string.lowFirstTitle
            ResultType.average ->  R.string.averageFirstTitle
            ResultType.high ->  R.string.highFirstTitle
            ResultType.veryHigh ->  R.string.veryHighFirstTitle
            else -> 0
        }
    }

    fun getResultSecondTitle(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.string.veryLowSecondTitle
            ResultType.low ->  R.string.lowSecondTitle
            ResultType.average ->  R.string.averageSecondTitle
            ResultType.high ->  R.string.highSecondTitle
            ResultType.veryHigh ->  R.string.veryHighSecondTitle
            else -> 0
        }
    }

    fun getResultBackgroundImage(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.drawable.green_screen
            ResultType.low ->  R.drawable.light_green_screen
            ResultType.average ->  R.drawable.yellow_screen
            ResultType.high ->   R.drawable.orange_screen
            ResultType.veryHigh ->  R.drawable.red_screen
            else -> 0
        }
    }

    fun getResultColor(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.color.colorGreen
            ResultType.low ->  R.color.colorLightGreen
            ResultType.average ->  R.color.colorYellow
            ResultType.high ->   R.color.colorOrange
            ResultType.veryHigh ->  R.color.colorRed
            else -> 0
        }
    }

    fun getSeparatorBackground(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.drawable.green_button_shape
            ResultType.low ->  R.drawable.light_green_button_shape
            ResultType.average ->  R.drawable.yellow_button_shape
            ResultType.high ->     R.drawable.orange_button_shape
            ResultType.veryHigh ->   R.drawable.red_button_shape
            else -> 0
        }
    }

    fun getResultReloadImage(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.drawable.green_button
            ResultType.low ->  R.drawable.light_green_button
            ResultType.average ->  R.drawable.yellow_button
            ResultType.high ->   R.drawable.orange_button
            ResultType.veryHigh ->  R.drawable.red_button
            else -> 0
        }
    }

    fun getResultText(type: Int): Int {
        return when (type) {
            ResultType.veryLow ->  R.string.veryLow
            ResultType.low ->  R.string.low
            ResultType.average ->  R.string.average
            ResultType.high ->  R.string.high
            ResultType.veryHigh ->  R.string.veryHigh
            else -> 0
        }
    }
}