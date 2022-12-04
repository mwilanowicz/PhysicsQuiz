package com.example.physicsquiz

// Plik z pytaniami
object Questions {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "Is earth flat?",false)
        questionsList.add(que1)

        val que2 = Question(2, "Is sun bright",true)
        questionsList.add(que2)

        val que3 = Question(3, "2 + 2 = 4?",true)
        questionsList.add(que3)

        val que4 = Question(4, "Was Kopernik a woman?",false)
        questionsList.add(que4)

        val que5 = Question(5, "Is there anything faster than light?",false)
        questionsList.add(que5)

        return questionsList
    }
}