package blackjack.model.card

class Hand(
    private val cards: List<Card>,
) {
    val size get() = cards.size

    operator fun plus(card: Card): Hand = Hand(this.cards + card)
}
