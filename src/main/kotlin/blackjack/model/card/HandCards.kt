package blackjack.model.card

class HandCards(
    private val value: MutableList<Card>,
) {
    fun getHandCardsInfo(): List<Card> = value.toList()

    fun add(card: Card) {
        value.add(card)
    }

    fun calculateScore(): Int {
        var score: Int = value.sumOf { card -> card.denomination.number }
        if (value.any { card -> card.isAce() } && score + 10 <= 21) {
            score += 10
        }
        return score
    }

    fun getCardsStatus(): CardsStatus {
        val cardsScore = calculateScore()
        return when {
            value.size == 2 && cardsScore == 21 -> CardsStatus.BLACKJACK
            cardsScore > 21 -> CardsStatus.BUST
            else -> CardsStatus.NONE
        }
    }

    companion object {
        fun from(vararg cards: Card): HandCards = HandCards(cards.toMutableList())
    }
}
