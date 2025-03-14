package blackjack.model.participant

import blackjack.model.state.StartGame
import blackjack.model.state.State

class Dealer(
    name: String = "딜러",
    state: State = StartGame(),
) : Participant(name, state)
