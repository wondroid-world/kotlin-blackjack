package blackjack.model.participant

import blackjack.model.state.StartGame
import blackjack.model.state.State

abstract class Participant(
    val name: String,
    val state: State,
)
