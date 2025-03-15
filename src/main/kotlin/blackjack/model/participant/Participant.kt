package blackjack.model.participant

import blackjack.model.card.Card
import blackjack.model.state.Hit
import blackjack.model.state.StartGame
import blackjack.model.state.State

abstract class Participant(
    val name: String,
    private var _state: State = StartGame(),
) {
    val state: State get() = _state

    fun updateState(card: Card) {
        _state = _state.draw(card)
    }

    fun stop() {
        if (_state is Hit) {
            _state = (_state as Hit).stop()
        }
    }
}
