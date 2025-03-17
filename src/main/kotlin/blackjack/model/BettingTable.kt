package blackjack.model

import blackjack.model.participant.Participant

class BettingTable(
    val participant: Participant,
    private val bettingAmount: Money,
) {
    fun getProfit(): Money {
        val participantState = participant.state
        return participantState.profit(bettingAmount)
    }

    companion object {
        const val ERROR_MESSAGE_PARTICIPANT_STATE_NOT_END = "참가자의 상태가 끝나지 않았습니다."
    }
}
