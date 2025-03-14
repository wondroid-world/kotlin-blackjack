package blackjack.view

import blackjack.model.card.CardShape
import blackjack.model.participant.Participant
import blackjack.model.participant.Player
import blackjack.model.participant.Players

class BlackjackView {
    fun startGame(): Players {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val players =
            readln()
                .split(",")
                .map { Player(name = it.trim()) }
        return Players(players)
    }

    fun settingBettingAmount(players: Players) {
        players.value.forEach { player ->
            println("${player.name}의 배팅 금액은?")
            val bettingAmount = readln().trim().toInt()
        }
    }

    fun giveCardsParticipants(participants: List<Participant>) {
        val participantsExceptedDealer = participants.filterNot { it.name == "딜러" }.joinToString()
        println("딜러와 ${participantsExceptedDealer}에게 2장의 나누었습니다.")
    }

    private fun getShapeName(shape: CardShape): String =
        when (shape) {
            CardShape.DIAMOND -> "다이아몬드"
            CardShape.SPADE -> "스페이드"
            CardShape.HEART -> "하트"
            CardShape.CLOVER -> "클로버"
        }
}
