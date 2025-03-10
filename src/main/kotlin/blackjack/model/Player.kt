package blackjack.model

class Player(
    name: String,
    cards: Cards = Cards(emptyList()),
) : Participant(name, cards) {
    lateinit var result: GameResult

    fun updateResult(dealerGameResult: GameResult) {
        result = GameResult.reversed(dealerGameResult)
    }
}
