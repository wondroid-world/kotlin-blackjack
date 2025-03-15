package blackjack.model.state

import blackjack.constants.BlackjackRule.BLACKJACK_PROFIT
import blackjack.model.card.Hand

class Blackjack(
    override val hand: Hand,
) : Finish(hand) {
    override val profitRate: Float
        get() = BLACKJACK_PROFIT
}
