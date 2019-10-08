package net.kathir.corountines
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sample_corountine_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SampleCorountinesActivity : AppCompatActivity()
{

    private val RESULT_1 = "Result #1"
    private val RESULT_2 = "Result #2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_corountine_layout)

        button.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeApiRequest()
            }
        }
    }

    private fun setNewText(input: String)
    {
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }


    private suspend fun setTextonMainThread(input : String)
    {
        withContext(Main){
            setNewText(input)
        }
    }

    private suspend fun fakeApiRequest()
    {
        val result1 = getResult1FromApi()
        println("debug : $result1")

        // Set the print-statement into UIThread
        setTextonMainThread(result1)

        val result2 = getResult2FromApi(result1)
        setTextonMainThread(result2)
    }


    private suspend fun getResult1FromApi() : String
    {
        logThread("getResult1FromApi")
        delay(1000)
        return RESULT_1

    }

    private suspend fun getResult2FromApi(result1 : String) : String
    {
        logThread("getResult2FromApi")
        delay(1000)
        return RESULT_2
    }

    private fun logThread(methodName: String)
    {
        println("debug:${methodName} : ${Thread.currentThread().name}")
    }

}