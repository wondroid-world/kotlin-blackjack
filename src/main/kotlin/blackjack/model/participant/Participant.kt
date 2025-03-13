package blackjack.model.participant

import blackjack.model.card.CardDeck
import blackjack.model.card.Cards
import blackjack.model.card.CardsStatus

abstract class Participant(
    val name: String,
    val cards: Cards,
) {
    fun addCard() = cards.add(CardDeck.pickCard())

    abstract fun getCardsStatus(): CardsStatus
}
