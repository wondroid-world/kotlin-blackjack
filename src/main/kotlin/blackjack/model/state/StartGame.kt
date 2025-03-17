package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

class StartGame(
    override val hand: Hand = Hand(emptyList()),
) : State {
    override fun draw(card: Card): Hit {
        val newHand = hand + card
        return Hit(newHand)
    }

    override fun stop(): State = Stay(hand)
}
