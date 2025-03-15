package blackjack.model.state

import blackjack.constants.BlackjackRule.BLACKJACK_SCORE
import blackjack.constants.BlackjackRule.FIRST_CARD_COUNT
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
            score < BLACKJACK_SCORE -> Hit(newHand)
            newHand.size == FIRST_CARD_COUNT && score == BLACKJACK_SCORE -> Blackjack(newHand)
            score > BLACKJACK_SCORE -> Bust(newHand)
            else -> Stay(newHand)
        }
    }

    fun stop(): State {
        val score = hand.score()
        return when {
            score > BLACKJACK_SCORE -> Bust(hand)
            else -> Stay(hand)
        }
    }
}
