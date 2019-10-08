package net.kathir.corountines.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.retrofit_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.kathir.corountines.R
import net.kathir.corountines.adapter.PostAdapter
import net.kathir.corountines.model.Post
import net.kathir.corountines.network.RetrofitFactory
import org.jetbrains.anko.toast
import retrofit2.HttpException

class RetrofitCorountinesActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retrofit_main)

        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts()
            try {
                withContext(Dispatchers.Main)
                {
                    if(response.isSuccessful)
                    {
                        response.body()?.let { initRecyclerView(it) }
                    }
                    else
                    {
                        toast("Error network operation ${response.code()}")
                    }
                }
            }catch (e: HttpException)
            {
                Log.e("REQUEST", "Exception ${e.message}")
            }
            catch (e: Throwable)
            {
                Log.e("REQUEST", "Ooops: Something else went wrong")
            }
        }

    }

    private fun initRecyclerView(list:List<Post>)
    {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = PostAdapter(list,this)
    }
}