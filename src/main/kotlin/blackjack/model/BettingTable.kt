package blackjack.model

import blackjack.model.participant.Participant
import blackjack.model.state.Finish

class BettingTable(
    val participant: Participant,
    private val bettingAmount: Money,
) {
    fun getProfit(): Money {
        val participantState = participant.state

        if (participantState !is Finish) {
            throw IllegalStateException("참가자의 상태가 끝나지 않았습니다.")
        }

        return participantState.profit(bettingAmount)
    }
}
