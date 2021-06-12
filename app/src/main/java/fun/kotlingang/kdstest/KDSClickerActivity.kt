package `fun`.kotlingang.kdstest

import `fun`.kotlingang.kds.KBundleDataStorage
import `fun`.kotlingang.kds.delegate.property
import `fun`.kotlingang.kds.extensions.instance_state_manager.fillState
import `fun`.kotlingang.kdstest.KDSClickerStorage.checked
import `fun`.kotlingang.kdstest.KDSClickerStorage.clicks
import `fun`.kotlingang.kdstest.databinding.MainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class KDSClickerActivity : AppCompatActivity() {
    private val v by lazy { MainBinding.inflate(layoutInflater) }

    private val state = object : KBundleDataStorage(json) {
        val startDate by property { LocalDateTime.now() }
    }

    override fun onCreate(savedInstanceState: Bundle?) = state.fillState(savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(v.root)

        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        v.date.text = getString(R.string.start_date, state.startDate.format(formatter))

        v.checkbox.isChecked = checked
        v.checkbox.setOnCheckedChangeListener { _, isChecked -> checked = isChecked }

        v.clicks.text = "$clicks"
        v.main.setOnClickListener {
            v.clicks.text = "${++clicks}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        state.saveInstanceState(outState)
    }
}
