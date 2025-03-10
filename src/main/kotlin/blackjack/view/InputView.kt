package blackjack.view

import blackjack.model.Player
import blackjack.model.PlayerBehavior
import blackjack.model.Players

class InputView {
    fun readPlayers(): Players {
        val players =
            readln()
                .split(",")
                .map { Player.from(name = it.trim()) }
        return Players(players)
    }

    fun readPlayerBehavior(): PlayerBehavior {
        val behavior = readln().trim().uppercase()
        return when (behavior) {
            "Y" -> PlayerBehavior.HIT
            "N" -> PlayerBehavior.STAY
            else -> throw IllegalArgumentException()
        }
    }
}
