package blackjack.model.participant

import blackjack.constants.BlackjackRule.MAX_PLAYERS
import blackjack.constants.BlackjackRule.MIN_PLAYERS

class Players(
    val value: List<Player>,
) {
    init {
        require(value.size in MIN_PLAYERS..MAX_PLAYERS) { "플레이어는 1명에서 8명까지 게임에 참여가능합니다." }
    }

    companion object {
        fun from(vararg names: String): Players = Players(names.map { name -> Player(name = name) })
    }
}
