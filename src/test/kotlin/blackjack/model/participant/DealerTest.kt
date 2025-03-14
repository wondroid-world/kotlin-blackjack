package blackjack.model.participant

import blackjack.model.card.Card
import blackjack.model.card.CardShape
import blackjack.model.card.Denomination
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class DealerTest {
    @Test
    fun `딜러는 이름이 없을 경우, 딜러라는 이름을 가진다`() {
        val dealer = Dealer()

        val expected = "딜러"

        assertThat(dealer.name).isEqualTo(expected)
    }
}
