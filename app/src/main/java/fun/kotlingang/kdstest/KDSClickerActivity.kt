package `fun`.kotlingang.kdstest

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class KDSClickerActivity : AppCompatActivity() {
    private val main: View by lazy { findViewById(R.id.main) }
    private val clicks: TextView by lazy { findViewById(R.id.clicks) }

    private val presenter = KDSClickerPresenter(activity = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        presenter.init()

        main.setOnClickListener {
            presenter.increaseClicks()
        }
    }

    fun updateClicks(clicksCount: Int) {
        clicks.text = "$clicksCount"
    }
}
