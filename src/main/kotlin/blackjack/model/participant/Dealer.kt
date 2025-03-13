package blackjack.model.participant

import blackjack.model.card.Cards
import blackjack.model.card.CardsStatus

class Dealer(
    name: String = "딜러",
    cards: Cards = Cards(emptyList()),
) : Participant(name, cards) {
    fun isPossibleToGetCard(): Boolean {
        while (isHit()) {
            addCard()
        }
        return false
    }

    fun isHit(): Boolean {
        val dealerScore = cards.calculateScore()
        return dealerScore <= 16
    }
}
