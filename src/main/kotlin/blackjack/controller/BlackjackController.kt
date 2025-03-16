package blackjack.controller

import blackjack.model.BettingTable
import blackjack.model.BlackjackGame
import blackjack.model.participant.*
import blackjack.model.state.Finish
import blackjack.view.BlackjackView

class BlackjackController(
    private val blackjackView: BlackjackView,
) {
    fun run() {
        val players = blackjackView.startGame()
        val dealer = Dealer()
        val bettingTables = blackjackView.settingBettingAmount(players)
        val blackjackGame = BlackjackGame(players, dealer)
        startGame(blackjackGame, dealer, players)
        playersTurn(players, blackjackGame)
        dealerTurn(blackjackGame)
        result(dealer, players, bettingTables)
    }

    private fun startGame(
        blackjackGame: BlackjackGame,
        dealer: Dealer,
        players: Players,
    ) {
        blackjackGame.firstTurn()
        blackjackView.giveCardsParticipants(dealer, players)
    }

    private fun playersTurn(
        players: Players,
        blackjackGame: BlackjackGame,
    ) {
        players.value.forEach { player ->
            while (player.state !is Finish) {
                val playerBehavior = blackjackView.getPlayerBehavior(player)
                blackjackGame.hitOrStay(player, playerBehavior)
            }
            blackjackView.showHands(player)
        }
    }

    private fun dealerTurn(blackjackGame: BlackjackGame) {
        if (blackjackGame.dealerTurn()) {
            blackjackView.showIsGetDealerCards()
        }
    }

    private fun result(
        dealer: Dealer,
        players: Players,
        bettingTables: List<BettingTable>,
    ) {
        blackjackView.showResult(dealer, players)
        blackjackView.showBettingResult(dealer, bettingTables)
    }
}