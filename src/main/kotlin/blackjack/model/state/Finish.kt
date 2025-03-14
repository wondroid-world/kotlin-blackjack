package blackjack.model.state

import blackjack.model.Money
import blackjack.model.card.Card
import blackjack.model.card.Hand

abstract class Finish(
    override val hand: Hand,
) : State {
    abstract val profitRate: Float

    fun profit(money: Money): Money = money * profitRate

    override fun draw(card: Card) = throw IllegalStateException("카드를 추가 할 수 없습니다.")
}
