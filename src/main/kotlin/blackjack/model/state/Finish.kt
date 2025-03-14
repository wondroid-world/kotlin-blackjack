package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

abstract class Finish(
    override val hand: Hand,
) : State(hand) {
    abstract val profitRate: Float

    override fun draw(card: Card) = throw IllegalStateException("카드를 추가 할 수 없습니다.")
}
