package `fun`.kotlingang.kdstest


class KDSClickerPresenter(private val activity: KDSClickerActivity) {
    private val model = KDSClickerModel()

    fun init() = activity.updateClicks(model.clicks)

    fun increaseClicks() = activity.updateClicks(++model.clicks)
}
