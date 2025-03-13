package blackjack.model.card

object CardDeck {
    private var index = 0

    private val DENOMINATIONS: List<Denomination> = Denomination.entries
    private val SHAPES: List<CardShape> = CardShape.entries

    private val CARDS: List<Card> =
        DENOMINATIONS
            .flatMap { denomination ->
                SHAPES.map { shape ->
                    Card(shape, denomination)
                }
            }.shuffled()

    fun pickCard(): Card = CARDS[index++]
}
