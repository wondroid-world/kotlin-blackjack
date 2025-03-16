package blackjack.model.state

import blackjack.constants.BlackjackRule.BUST_PROFIT
import blackjack.model.card.Hand

class Bust(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = BUST_PROFIT
}
