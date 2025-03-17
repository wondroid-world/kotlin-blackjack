package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

class Hit(
    override val hand: Hand,
) : State {
    override fun draw(card: Card): State {
        val newHand = hand + card
        val score = newHand.score()
        return when {
            score < BLACKJACK_SCORE -> Hit(newHand)
            newHand.size == FIRST_CARD_COUNT && score == BLACKJACK_SCORE -> Blackjack(newHand)
            score > BLACKJACK_SCORE -> Bust(newHand)
            else -> Stay(newHand)
        }
    }

    override fun stop(): State = Stay(hand)

    companion object {
        const val FIRST_CARD_COUNT = 2
        const val BLACKJACK_SCORE = 21
    }
}
