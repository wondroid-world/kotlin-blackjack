package blackjack.model.card

class Hand(
    private val cards: List<Card>,
) {
    constructor(vararg cards: Card) : this(cards.toList())

    val size get() = cards.size

    fun score(): Int {
        val score = cards.sumOf { it.denomination.number }
        if (cards.any { it.isAce() } && score + 10 <= 21) {
            return score + 10
        }
        return score
    }

    operator fun plus(card: Card): Hand = Hand(this.cards + card)
}
