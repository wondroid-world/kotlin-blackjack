package blackjack.model.participant

import blackjack.model.card.Card
import blackjack.model.state.Hit
import blackjack.model.state.StartGame
import blackjack.model.state.State

abstract class Participant(
    val name: String,
    state: State = StartGame(),
) {
    var state: State = state
        private set

    fun updateState(card: Card) {
        state = state.draw(card)
    }

    fun stop() {
        if (state is Hit) {
            state = (state as Hit).stop()
        }
    }
}
