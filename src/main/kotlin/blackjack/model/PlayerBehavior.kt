package blackjack.model

enum class PlayerBehavior {
    HIT,
    STAY,
    ;

    companion object {
        fun from(dealerScore: Int): PlayerBehavior {
            if (dealerScore <= 16) return HIT
            return STAY
        }
    }
}
