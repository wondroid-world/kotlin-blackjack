package blackjack.model

abstract class Participant(
    val name: String,
    val cards: Cards,
) {
    protected fun addCard(card: Card) = cards.add(card)
}
