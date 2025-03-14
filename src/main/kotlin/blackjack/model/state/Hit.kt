package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

class Hit(
    override val hand: Hand,
) : State {
    val size: Int get() = hand.size

    override fun draw(card: Card): State {
        val newHand = hand + card
        val score = newHand.score()
        return when {
            score < 21 -> Hit(newHand)
            newHand.size == 2 && score == 21 -> Blackjack(newHand)
            score > 21 -> Bust(newHand)
            else -> Stay(newHand)
        }
    }

    fun stop(): State {
        val score = hand.score()
        return when {
            score > 21 -> Bust(hand)
            else -> Stay(hand)
        }
    }
}
