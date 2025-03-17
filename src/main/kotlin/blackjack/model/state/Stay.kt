package blackjack.model.state

import blackjack.constants.BlackjackRule.STAY_PROFIT
import blackjack.model.card.Hand

class Stay(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = STAY_PROFIT
}
