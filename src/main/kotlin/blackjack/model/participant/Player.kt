package blackjack.model.participant

import blackjack.constants.BlackjackRule.NAME_LENGTH_MAX
import blackjack.constants.BlackjackRule.NAME_LENGTH_MIN
import blackjack.model.state.StartGame
import blackjack.model.state.State

class Player(
    name: String,
    state: State = StartGame(),
) : Participant(name, state) {
    init {
        require(name != "딜러") { "플레이어는 딜러라는 이름을 가질 수 없습니다." }
        require(name.length in NAME_LENGTH_MIN..NAME_LENGTH_MAX) { "플레이어는 1에서 5사이 길이의 이름만 가질 수 있습니다." }
    }
}
