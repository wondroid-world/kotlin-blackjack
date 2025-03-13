package blackjack.model

import blackjack.model.card.Card
import blackjack.model.card.CardShape
import blackjack.model.card.Cards
import blackjack.model.card.Denomination
import blackjack.model.participant.Dealer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class DealerTest {
    @Test
    fun `딜러는 이름과 카드들을 가진다`() {
        val cards = Cards(listOf((Card(CardShape.HEART, Denomination.FIVE)), Card(CardShape.CLOVER, Denomination.TWO)))
        val dealer = Dealer(cards = cards)

        assertAll({ assertThat(dealer.name).isEqualTo("딜러") }, { assertThat(dealer.cards).isEqualTo(cards) })
    }

    @Test
    fun `딜러는 이름이 없을 경우, 딜러라는 이름을 가진다`() {
        val dealer = Dealer()

        val expected = "딜러"

        assertThat(dealer.name).isEqualTo(expected)
    }

    @Test
    fun `딜러의 카드 리스트의 초기값은 비어있다`() {
        val dealer = Dealer()

        val expected = 0

        assertThat(dealer.cards.value.size).isEqualTo(expected)
    }

    @Test
    fun `딜러는 카드를 추가로 받을 수 있다`() {
        val dealer = Dealer()
        val card = Card(CardShape.CLOVER, Denomination.SIX)
        dealer.addCard(card)

        val expected = 1

        assertThat(dealer.cards.value.size).isEqualTo(expected)
    }

    @Test
    fun `딜러의 스코어가 16 이하일 경우 isHit은 true를 반환한다`() {
        val cards =
            Cards(
                listOf(
                    Card(CardShape.DIAMOND, Denomination.TEN),
                    Card(CardShape.CLOVER, Denomination.TWO),
                ),
            )
        val dealer = Dealer(cards = cards)

        val actual = dealer.isHit()

        val expected = true

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `딜러의 스코어가 16초과일 경우 isHit은 false를 반환한다`() {
        val cards =
            Cards(
                listOf(
                    Card(CardShape.DIAMOND, Denomination.TEN),
                    Card(CardShape.CLOVER, Denomination.TEN),
                ),
            )
        val dealer = Dealer(cards = cards)

        val actual = dealer.isHit()

        val expected = false

        assertThat(actual).isEqualTo(expected)
    }
}
