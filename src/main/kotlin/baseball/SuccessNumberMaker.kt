package baseball

import camp.nextstep.edu.missionutils.Randoms

class SuccessNumberMaker {

    fun makeSuccessNumber(): String {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3).toString()
    }
}