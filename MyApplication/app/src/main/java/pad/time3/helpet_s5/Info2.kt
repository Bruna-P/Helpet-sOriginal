package pad.time3.helpet_s5

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info2.*
import kotlinx.android.synthetic.main.activity_main.*

class Info2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2)

        idContactong.setOnClickListener {
            val intent = Intent(this, userong::class.java)
            startActivity(intent)
        }

        idExit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}