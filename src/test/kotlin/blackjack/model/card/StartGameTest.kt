package blackjack.model.card

import blackjack.model.state.StartGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StartGameTest {
    @Test
    fun `게임을 시작하면, 카드를 한장 나누어 준다`() {
        val card = Card(CardShape.HEART, Denomination.TWO)
        val startGame = StartGame()
        val hit = startGame.draw(card)

        val actual = hit.size

        val expected = 1

        assertThat(actual).isEqualTo(expected)
    }
}
