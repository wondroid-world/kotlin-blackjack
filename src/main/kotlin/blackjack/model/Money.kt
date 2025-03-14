package blackjack.model

@JvmInline
value class Money(
    private val value: Int,
) {
    operator fun times(profitRate: Float): Money = Money((this.value * profitRate).toInt())
}
