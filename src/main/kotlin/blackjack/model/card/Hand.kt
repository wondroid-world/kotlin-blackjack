package blackjack.model.card

import blackjack.constants.BlackjackRule

class Hand(
    val cards: List<Card>,
) {
    constructor(vararg cards: Card) : this(cards.toList())

    val size get() = cards.size

    fun score(): Int {
        val score = cards.sumOf { it.denomination.number }
        if (cards.any { it.isAce() } && score + 10 <= BlackjackRule.BLACKJACK_SCORE) {
            return score + 10
        }
        return score
    }

    operator fun plus(card: Card): Hand = Hand(this.cards + card)
}
