package blackjack.controller

import blackjack.model.GameResult
import blackjack.model.participant.*
import blackjack.view.InputView
import blackjack.view.OutputView

class BlackjackController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    val winners = mutableListOf<Participant?>()

    fun run() {
        val players = getPlayers()
        val dealer = Dealer()
        val oneRound = GamePlaying(dealer, players)
        // 카드를 2장씩 나누어 준다.
        oneRound.startGame()
        outputView.printPlayersCards(dealer, players)

        // 플레이어들이 카드를 받는다
        players.value.forEach { player ->
            var repeat = true
            while (repeat) {
                outputView.printPlayerBehaviorGuide(player)
                val playerBehavior = inputView.readPlayerBehavior()
                repeat = player.isPossibleToGetCard(playerBehavior)
            }
            outputView.printPlayerCard(player)
        }

        dealer.isPossibleToGetCard()

        players.value.forEach { player ->
            val winner = GameResult(dealer, player).getWinner()
            winners.add(winner)
        }
        println(winners)
        outputView.printResult(dealer, players, winners)
    }

    private fun getPlayers(): Players {
        outputView.printStartMessage()
        val players: Players = inputView.readPlayers()
        return players
    }
}
