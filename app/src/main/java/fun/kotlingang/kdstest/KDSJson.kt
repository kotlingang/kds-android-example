package `fun`.kotlingang.kdstest

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual


val json = Json {
    serializersModule = SerializersModule {
        contextual(LocalDateTimeSerializer)
    }
}
