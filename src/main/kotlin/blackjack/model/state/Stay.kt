package blackjack.model.state

import blackjack.model.card.Hand

class Stay(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = 1f
}
