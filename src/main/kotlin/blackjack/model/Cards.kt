package blackjack.model

class Cards(
    value: List<Card>,
) {
    private val _value: MutableList<Card> = value.toMutableList()
    val value: List<Card> get() = _value.map { card -> card.copy() }

    var size: Int = this.value.size
        private set

    fun add(card: Card) {
        _value.add(card)
    }

    fun calculateScore(): Int {
        val aceCount: Int = value.count { card -> card.isAce() }
        val score: Int = value.sumOf { card -> card.denomination.number }
        return when (aceCount) {
            1 -> if (score < 11) score + 11 else score + 1
            2 -> if (score < 10) score + 11 + 1 else score + aceCount * 1
            3 -> if (score < 9) score + 11 + 1 + 1 else score + aceCount * 1
            4 -> if (score < 8) score + 11 + 1 + 1 + 1 else score + aceCount * 1
            else -> score
        }
    }

    fun getStatus(): CardsStatus {
        val cardsScore = calculateScore()
        if (this.size == 2 && cardsScore == 21) return CardsStatus.BLACKJACK
        if (cardsScore > 21) return CardsStatus.BUST
        return CardsStatus.NONE
    }
}
