package blackjack.controller

import blackjack.model.participant.*
import blackjack.view.BlackjackView

class BlackjackController(
    private val blackjackView: BlackjackView,
) {
    val players = blackjackView.startGame()
    val dealer = Dealer()
}
