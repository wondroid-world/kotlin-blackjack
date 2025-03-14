package blackjack.model.participant

import blackjack.model.card.HandCards

class Dealer(
    name: String = "딜러",
    handCards: HandCards = HandCards(mutableListOf()),
) : Participant(name, handCards) {
    fun isHit(): Boolean {
        val dealerScore = handCards.calculateScore()
        return dealerScore <= 16
    }
}
