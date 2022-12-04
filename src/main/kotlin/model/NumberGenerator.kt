package model

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {

    fun makeNumber(): String {
        val randomNumberList = mutableListOf<Int>()

        repeat(3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!randomNumberList.contains(randomNumber)) randomNumberList.add(randomNumber)
        }

        return randomNumberList.joinToString("")
    }

}