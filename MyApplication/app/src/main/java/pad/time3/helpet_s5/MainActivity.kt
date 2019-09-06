package pad.time3.helpet_s5

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        idSignin.setOnClickListener {
            val intent = Intent(this, Info2::class.java)
            startActivity(intent)
        }

       idRegister1.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)

       }
    }
}
