package blackjack.view

import blackjack.model.card.CardShape
import blackjack.model.participant.Dealer
import blackjack.model.participant.Participant
import blackjack.model.participant.Player
import blackjack.model.participant.Players

class OutputView {
    fun printStartMessage() {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
    }

    private fun getShapeName(shape: CardShape): String =
        when (shape) {
            CardShape.DIAMOND -> "다이아몬드"
            CardShape.SPADE -> "스페이드"
            CardShape.HEART -> "하트"
            CardShape.CLOVER -> "클로버"
        }

    fun printPlayersCards(
        dealer: Dealer,
        players: Players,
    ) {
        val playersNames: String = players.value.joinToString(", ") { it.name }
        println("\n${dealer.name}와 ${playersNames}에게 2장의 카드를 나누었습니다.")
        println(
            "${dealer.name}: ${
                dealer.cards.value[0]
                    .denomination.title + getShapeName(dealer.cards.value[0].shape)
            }",
        )
        players.value.forEach { player ->
            printPlayerCard(player)
        }
        println()
    }

    fun printPlayerBehaviorGuide(player: Player) {
        println("${player.name}는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)")
    }

    fun printPlayerCard(player: Player) {
        println(
            "${player.name}카드: ${
                player.cards.value.map { it.denomination.title + getShapeName(it.shape) }.joinToString(", ")
            }",
        )
    }

    fun printResult(
        dealer: Dealer,
        players: Players,
        winners: List<Participant?>
    ) {
        val results: MutableList<String> = mutableListOf()

        println(
            "\n${dealer.name}카드: ${
                dealer.cards.value.map { it.shape.toString() + it.denomination }.joinToString(", ")
            } - 결과: ${dealer.cards.calculateScore()}",
        )
        players.value.forEach { player ->
            println(
                "${player.name}카드: ${
                    player.cards.value.map { it.shape.toString() + it.denomination }.joinToString(", ")
                } - 결과: ${player.cards.calculateScore()}",
            )
        }

        println("\n## 최종 승패")
        println("${dealer.name}: ${results.joinToString(" ")}")
        players.value.forEach { player ->
            println("${player.name}: ${player}")
        }
    }
}
