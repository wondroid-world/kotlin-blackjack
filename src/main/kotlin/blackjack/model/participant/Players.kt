package blackjack.model.participant

class Players(
    val value: List<Player>,
) {
    init {
        require(value.size in 1..8) { "플레이어는 1명에서 8명까지 게임에 참여가능합니다." }
    }

    companion object {
        fun from(vararg names: String): Players = Players(names.map { name -> Player(name = name) })
    }
}
