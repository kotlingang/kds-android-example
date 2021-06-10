package `fun`.kotlingang.kdstest

import `fun`.kotlingang.kds.KDS
import android.app.Application


class KDSClickerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KDS.onCreate(app = this)
    }
}
