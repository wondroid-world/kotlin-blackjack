package blackjack.model.participant

import blackjack.model.PlayerBehavior
import blackjack.model.card.Cards
import blackjack.model.card.CardsStatus

class Player(
    name: String,
    cards: Cards = Cards(emptyList()),
) : Participant(name, cards) {
    init {
        require(name != "딜러") { "플레이어는 딜러라는 이름을 가질 수 없습니다." }
        require(name.length in 1..5) { "플레이어는 1에서 5사이 길이의 이름만 가질 수 있습니다." }
    }

    fun isPossibleToGetCard(playerBehavior: PlayerBehavior): Boolean {
        if (cards.getStatus() != CardsStatus.BUST && playerBehavior == PlayerBehavior.HIT) {
            addCard()
        }
        return false
    }
}
