package baseball

import camp.nextstep.edu.missionutils.Randoms

class SuccessNumberMaker {

    fun makeSuccessNumber(): String {
        val randomNumberList = Randoms.pickUniqueNumbersInRange(1, 9, 3)

        return "${randomNumberList[0]}${randomNumberList[1]}${randomNumberList[2]}"
    }
}