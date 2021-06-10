package `fun`.kotlingang.kdstest

import `fun`.kotlingang.kds.KSharedDataStorage
import `fun`.kotlingang.kds.delegate.int


object KDSClickerStorage : KSharedDataStorage() {
    var clicks by int { 0 }
}
