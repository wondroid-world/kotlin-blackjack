package blackjack.model.card

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HandCardsTest {
    @Test
    fun `Hands을 생성자로 카드 리스트를 받는다`() {
        val cards = mutableListOf((Card(CardShape.HEART, Denomination.FIVE)), Card(CardShape.CLOVER, Denomination.TWO))
        val actual = HandCards(cards)

        assertThat(actual.getHandCardsInfo()).isEqualTo(cards)
    }

    @Test
    fun `카드들의 정보를 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.NINE),
            )

        assertThat(handCards.getHandCardsInfo()).isEqualTo(
            listOf(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.NINE),
            ),
        )
    }

    @Test
    fun `카드들에 카드를 추가한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.NINE),
            )

        val addCard = Card(CardShape.CLOVER, Denomination.TWO)
        handCards.add(addCard)

        assertThat(handCards.getHandCardsInfo()).isEqualTo(
            listOf(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.NINE),
                Card(CardShape.CLOVER, Denomination.TWO),
            ),
        )
    }

    @Test
    fun `HandCards는 카드들의 점수를 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.FIVE),
                Card(CardShape.CLOVER, Denomination.TWO),
            )

        val actual = handCards.calculateScore()

        assertThat(actual).isEqualTo(7)
    }

    @Test
    fun `Ace 카드가 있고 점수의 합이 11이하 일때, 카드 점수에 10을 더해서 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.KING),
            )

        val actual = handCards.calculateScore()

        val expected = (Denomination.ACE.number + Denomination.KING.number) + 10

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `카드가 2장이고 카드들의 합이 21이면 CardsStatus의 BLACKJACK 값을 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.TEN),
            )

        val actual = handCards.getCardsStatus()

        val expected = CardsStatus.BLACKJACK

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `첫 턴이 아니고 카드들의 합이 21를 초과하면 CardsStatus의 BUST 값을 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.TEN),
                Card(CardShape.DIAMOND, Denomination.TEN),
                Card(CardShape.CLOVER, Denomination.TWO),
            )

        val actual = handCards.getCardsStatus()

        val expected = CardsStatus.BUST

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `카드가 2장이 아니고 카드들의 합이 21이하이면 CardsStatus의 NONE 값을 반환한다`() {
        val handCards =
            HandCards.from(
                Card(CardShape.HEART, Denomination.ACE),
                Card(CardShape.CLOVER, Denomination.TWO),
            )
        val actual = handCards.getCardsStatus()

        val expected = CardsStatus.NONE

        assertThat(actual).isEqualTo(expected)
    }
}
