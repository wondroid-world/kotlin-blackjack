package blackjack.model.card

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StartGameTest {
    @Test
    fun `게임을 시작하면, 카드를 한장 나누어 준다`() {
        val card = Card(CardShape.HEART, Denomination.TWO)
        val startGame = StartGame()
        val hit = startGame.draw(card)

        val actual = hit.hand.cards

        val expected = 1

        assertThat(actual).hasSize(expected)
    }
}

class StartGame(
    val hand: Hand = Hand(emptyList()),
) {
    fun draw(card: Card): Hit {
        val newHand = hand + card
        return Hit(newHand)
    }
}

class Hand(
    val cards: List<Card>
) {
    val size get() = cards.size

    operator fun plus(card: Card): Hand = Hand(this.cards + card)
}

class Hit(
    val hand: Hand,
) {
    fun draw(card: Card) {
        val newHand = hand + card
//        return Hit(newHand)
    }


}