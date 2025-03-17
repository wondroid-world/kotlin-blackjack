package blackjack.model.state

import blackjack.model.card.Hand

class Bust(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = BUST_PROFIT

    companion object {
        const val BUST_PROFIT = -1f
    }
}
