package blackjack.model

import blackjack.model.card.CardDeck
import blackjack.model.participant.Dealer
import blackjack.model.participant.Player
import blackjack.model.participant.Players

class BlackjackGame(
    private val players: Players,
    private val dealer: Dealer,
) {
    private val cardDeck = CardDeck.create()

    fun firstTurn() {
        repeat(2) {
            giveCard()
        }
    }

    private fun giveCard() {
        dealer.updateState(cardDeck.pickCard())
        players.value.forEach { player ->
            player.updateState(cardDeck.pickCard())
        }
    }

    fun dealerTurn(): Boolean {
        while (dealer.isCanHit()) {
            dealer.updateState(cardDeck.pickCard())
            return true
        }
        return false
    }

    fun hitOrStay(
        player: Player,
        playerBehavior: PlayerBehavior,
    ) {
        when (playerBehavior) {
            PlayerBehavior.HIT -> player.updateState(cardDeck.pickCard())
            PlayerBehavior.STAY -> player.stop()
        }
    }
}
