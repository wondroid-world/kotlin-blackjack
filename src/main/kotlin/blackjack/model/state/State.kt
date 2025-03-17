package blackjack.model.state

import blackjack.model.card.Card
import blackjack.model.card.Hand

interface State {
    val hand: Hand

    fun draw(card: Card): State

    fun stop(): State
}
