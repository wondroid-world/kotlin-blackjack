package blackjack.model.participant

import blackjack.model.card.Card
import blackjack.model.card.CardShape
import blackjack.model.card.Denomination
import blackjack.model.card.HandCards
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
    @Test
    fun `플레이어는 이름과 카드 리스트를 가진다`() {
        val cards = mutableListOf((Card(CardShape.HEART, Denomination.FIVE)), Card(CardShape.CLOVER, Denomination.TWO))
        val player = Player("모찌", HandCards(cards))
        assertAll({
            assertThat(player.name).isEqualTo("모찌")
            assertThat(player.handCards.getHandCardsInfo()).isEqualTo(cards)
        })
    }

    @Test
    fun `플레이어는 카드를 추가로 받을 수 있다`() {
        val initialHands =
            HandCards(
                mutableListOf((Card(CardShape.HEART, Denomination.FIVE)), Card(CardShape.CLOVER, Denomination.TWO)),
            )
        val player = Player("모찌", initialHands)
        val card = Card(CardShape.CLOVER, Denomination.SIX)
        player.addCard(card)

        assertThat(player.handCards.getHandCardsInfo()).isEqualTo(
            listOf(
                Card(CardShape.HEART, Denomination.FIVE),
                Card(CardShape.CLOVER, Denomination.TWO),
                Card(CardShape.CLOVER, Denomination.SIX),
            ),
        )
    }

    @Test
    fun `플레이어가 이름만 가질 경우, 가진 카드 리스트는 비어있다`() {
        val player = Player("모찌")
        assertThat(player.handCards.getHandCardsInfo().size).isEqualTo(0)
    }

    @Test
    fun `플레이어의 이름이 딜러이면 에러를 반환한다`() {
        assertThrows<IllegalArgumentException> { Player("딜러") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다라마바사", ""])
    fun `플레이어의 이름이 1~5자를 넘어가면 에러를 반환한다`(name: String) {
        assertThrows<IllegalArgumentException> { Player(name) }
    }
}
