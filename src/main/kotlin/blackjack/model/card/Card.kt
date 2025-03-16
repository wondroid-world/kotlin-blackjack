package blackjack.model.card

data class Card(
    val shape: CardShape,
    val denomination: Denomination,
) {
    fun isAce(): Boolean = denomination == Denomination.ACE
}
