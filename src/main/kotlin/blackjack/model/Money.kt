package blackjack.model

@JvmInline
value class Money(
    val value: Int,
) {
    operator fun times(profitRate: Float): Money = Money((this.value * profitRate).toInt())
}
