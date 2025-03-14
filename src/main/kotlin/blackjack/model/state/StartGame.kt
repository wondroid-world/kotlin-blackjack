package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

class StartGame(
    private val hand: Hand = Hand(emptyList()),
) {
    fun draw(card: Card): Hit {
        val newHand = hand + card
        return Hit(newHand)
    }
}
