package baseball

import camp.nextstep.edu.missionutils.Randoms

class SuccessNumberMaker {

    fun makeSuccessNumber(): String {
        val randomNumberList = mutableListOf<Int>()

        while (randomNumberList.size != 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumberList.contains(randomNumber)) continue
            randomNumberList.add(randomNumber)
        }

        return randomNumberList.joinToString("")
    }

}