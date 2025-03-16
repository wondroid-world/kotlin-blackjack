package blackjack.model.card

class CardDeck private constructor(
    private val trumpCard: List<Card>,
) {
    private var index = 0

    fun pickCard(): Card = trumpCard[index++]

    companion object {
        fun create(): CardDeck {
            val shuffledTrumpCard = TrumpCard.CARDS.shuffled()
            return CardDeck(shuffledTrumpCard)
        }
    }
}
