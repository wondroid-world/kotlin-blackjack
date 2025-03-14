package blackjack.model.participant

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
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
