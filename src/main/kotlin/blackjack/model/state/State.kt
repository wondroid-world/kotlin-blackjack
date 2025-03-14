package blackjack.model.state

import blackjack.model.card.Hand

abstract class State(
    open val hand: Hand,
)
