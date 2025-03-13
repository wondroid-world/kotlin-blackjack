package blackjack.model

import blackjack.model.participant.Dealer
import blackjack.model.participant.Participant
import blackjack.model.participant.Player

class GameResult(
    private val dealer: Dealer,
    private val player: Player,
) {
    fun getWinner(): Participant? {
        val dealerScore = dealer.cards.calculateScore()
        val playerScore = player.cards.calculateScore()
        return when {
            playerScore > 21 -> dealer
            dealerScore in (playerScore + 1)..21 -> dealer
            playerScore in (dealerScore + 1)..21 -> player
            dealerScore > 21 -> player
            else -> null
        }
    }
}
