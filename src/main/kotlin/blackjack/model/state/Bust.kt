package blackjack.model.state

import blackjack.model.card.Hand

class Bust(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = 0f
}
