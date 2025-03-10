package blackjack.model.participant

import blackjack.model.card.Card
import blackjack.model.card.Cards

abstract class Participant(
    val name: String,
    val cards: Cards,
) {
    fun addCard(card: Card) = cards.add(card)
}
