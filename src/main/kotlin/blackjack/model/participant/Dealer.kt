package blackjack.model.participant

import blackjack.constants.BlackjackRule.DEALER_HIT_SCORE
import blackjack.model.state.StartGame
import blackjack.model.state.State

class Dealer(
    name: String = "딜러",
    state: State = StartGame(),
) : Participant(name, state) {
    fun isCanHit(): Boolean = state.hand.score() <= DEALER_HIT_SCORE
}
