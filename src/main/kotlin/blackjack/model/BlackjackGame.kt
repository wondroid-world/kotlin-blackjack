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
        repeat(FIRST_CARD_COUNT) {
            giveCard(cardDeck)
        }
    }

    private fun giveCard(cardDeck: CardDeck) {
        dealer.updateState(cardDeck.pickCard())
        players.giveCardForPlayer(cardDeck)
    }

    fun dealerTurn(): Boolean {
        while (dealer.canDraw()) {
            dealer.updateState(cardDeck.pickCard())
            return true
        }
        return false
    }

    fun playerTurn(player: Player) {
        player.updateState(cardDeck.pickCard())
    }

    companion object {
        const val FIRST_CARD_COUNT = 2
    }
}
