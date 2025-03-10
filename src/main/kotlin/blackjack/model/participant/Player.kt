package blackjack.model.participant

import blackjack.model.GameResult
import blackjack.model.card.Cards

class Player(
    name: String,
    cards: Cards = Cards(emptyList()),
) : Participant(name, cards) {
    lateinit var result: GameResult

    fun updateResult(dealerGameResult: GameResult) {
        result = GameResult.reversed(dealerGameResult)
    }
}
