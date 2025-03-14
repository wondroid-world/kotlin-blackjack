package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

class Hit(
    private val hand: Hand,
) {
    val size: Int get() = hand.size

    fun draw(card: Card) {
        val newHand = hand + card
//        return Hit(newHand)
    }
}
