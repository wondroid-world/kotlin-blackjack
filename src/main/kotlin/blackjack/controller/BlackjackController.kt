package blackjack.controller

import blackjack.model.card.CardDeck
import blackjack.model.card.CardsMaker
import blackjack.model.card.CardsStatus
import blackjack.model.participant.Dealer
import blackjack.model.GameResult
import blackjack.model.participant.Player
import blackjack.model.PlayerBehavior
import blackjack.model.participant.Players
import blackjack.view.InputView
import blackjack.view.OutputView

class BlackjackController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val cardDeck = CardDeck(CardsMaker.CARDS)

    fun run() {
        outputView.printStartMessage()
        val players: Players = inputView.readPlayers()
        val dealer = Dealer()

        getCards(players, dealer)
        playGames(players, dealer)
    }

    private fun getCards(
        players: Players,
        dealer: Dealer,
    ) {
        repeat(2) {
            getCardsToPlayer(players.value)
            getCardsToDealer(dealer)
        }
        outputView.printPlayersCards(dealer, players.value)
    }

    private fun getCardsToPlayer(players: List<Player>) {
        players.forEach { player ->
            val card = cardDeck.pickCard()
            player.addCard(card)
        }
    }

    private fun getCardsToDealer(dealer: Dealer) {
        val card = cardDeck.pickCard()
        dealer.addCard(card)
    }

    private fun playGames(
        players: Players,
        dealer: Dealer,
    ) {
        if (dealer.cards.getStatus() == CardsStatus.BLACKJACK) {
            val blackjackPlayers: List<Player> = players.findBlackjackPlayer()
            updateGameResult(players, dealer)
            outputView.printDealerBlackjackMessage(dealer, blackjackPlayers)
            displayResult(players, dealer)
            return
        }
        players.value.forEach { player ->
            playGame(player, dealer)
        }
        displayResult(players, dealer)
    }

    private fun updateGameResult(
        players: Players,
        dealer: Dealer,
    ) {
        players.value.forEach { player ->
            if (isAllPlayerBlackjack(player, dealer)) return@forEach
            player.updateResult(GameResult.WIN)
            dealer.updateResult(player.cards.calculateScore())
        }
    }

    private fun isAllPlayerBlackjack(
        player: Player,
        dealer: Dealer,
    ): Boolean {
        if (player.cards.getStatus() == CardsStatus.BLACKJACK) {
            player.updateResult(GameResult.PUSH)
            dealer.updateResult(player.cards.calculateScore())
            return true
        }
        return false
    }

    private fun playGame(
        player: Player,
        dealer: Dealer,
    ) {
        if (isPlayerBlackjack(player, dealer)) return
        executePlayerGameLogic(player)
        executeDealerGameLogic(dealer)
        val dealerResult: GameResult = dealer.updateResult(dealer.cards.calculateScore())
        player.updateResult(dealerResult)
    }

    private fun isPlayerBlackjack(
        player: Player,
        dealer: Dealer,
    ): Boolean {
        if (player.cards.getStatus() == CardsStatus.BLACKJACK) {
            val dealerResult: GameResult = dealer.updateResult(21)
            player.updateResult(dealerResult)
            return true
        }
        return false
    }

    private fun executePlayerGameLogic(player: Player) {
        while (player.cards.getStatus() != CardsStatus.BUST) {
            outputView.printPlayerBehaviorGuide(player)
            val playerBehavior: PlayerBehavior = inputView.readPlayerBehavior()

            if (executePlayerBehavior(playerBehavior, player)) break
        }
    }

    private fun executePlayerBehavior(
        playerBehavior: PlayerBehavior,
        player: Player,
    ): Boolean {
        when (playerBehavior) {
            PlayerBehavior.HIT -> {
                player.addCard(cardDeck.pickCard())
                outputView.printPlayerCard(player)
                if (isPlayerBust(player)) return true
            }

            PlayerBehavior.STAY -> return true
        }
        return false
    }

    private fun isPlayerBust(player: Player): Boolean {
        if (player.cards.getStatus() == CardsStatus.BUST) {
            outputView.printBust(player)
            return true
        }
        return false
    }

    private fun executeDealerGameLogic(dealer: Dealer) {
        while (dealer.isHit()) {
            dealer.addCard(cardDeck.pickCard())
            outputView.printDealerGettingCard()
            if (isDealerBust(dealer)) break
        }
    }

    private fun isDealerBust(dealer: Dealer): Boolean {
        if (dealer.cards.getStatus() == CardsStatus.BUST) {
            outputView.printBust(dealer)
            return true
        }
        return false
    }

    private fun displayResult(
        players: Players,
        dealer: Dealer,
    ) {
        outputView.printResult(dealer, players)
    }
}
