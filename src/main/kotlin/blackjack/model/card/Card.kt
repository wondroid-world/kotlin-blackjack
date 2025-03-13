package blackjack.model.card

import java.util.Objects
import kotlin.jvm.internal.Ref.ObjectRef

data class Card(
    val shape: CardShape,
    val denomination: Denomination,
) {
    fun isAce(): Boolean = denomination == Denomination.ACE
}
