package blackjack.model.card

class Cards(
    value: List<Card>,
) {
    private val _value: MutableList<Card> = value.toMutableList()
    val value: List<Card> get() = _value.map { card -> card.copy() }

    fun add(card: Card) {
        _value.add(card)
    }

    fun calculateScore(): Int {
        var score: Int = value.sumOf { card -> card.denomination.number }
        if (value.any { card -> card.isAce() } && score + 10 <= 21) {
            score += 10
        }
        return score
    }

    fun getStatus(): CardsStatus {
        val cardsScore = calculateScore()
        if (_value.size == 2 && cardsScore == 21) return CardsStatus.BLACKJACK
        if (cardsScore > 21) return CardsStatus.BUST
        return CardsStatus.NONE
    }
}
