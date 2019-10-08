package net.kathir.corountines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.kathir.corountines.activity.RetrofitCorountinesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_sample_coruntines = findViewById(R.id.sample_corountines) as Button
        btn_sample_coruntines.setOnClickListener {

            val intent = Intent(this, SampleCorountinesActivity::class.java)
            startActivity(intent)
        }

        retofitkotlin.setOnClickListener {

            val intent = Intent(this, RetrofitCorountinesActivity::class.java)
            startActivity(intent)
        }

        corountine_job.setOnClickListener {

            val intent = Intent(this, CorountinesJobActivity::class.java)
            startActivity(intent)
        }

    }
}
