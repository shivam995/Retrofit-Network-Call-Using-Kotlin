package com.sample.sampleretrofil_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var provider : WebServiceProvider?= null
    val showName = "Game of Thrones"
    val season = "1"
    val API_KEY = "REPLACE_WITH_YOUR_API_KEY" //get apiKey from http://www.omdbapi.com/apikey.aspx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        provider = WebServiceProvider.retrofit.create(WebServiceProvider::class.java)

        fetchButton.setOnClickListener {
            fetchData()
        }
    }

    /**
     * This will fetch list of episodes from server
     */
    private fun fetchData() {
        loading.visibility = View.VISIBLE

        provider?.getEpisodes(showName, season, API_KEY)
                //specify the Scheduler on which an observer will observe, here is Android's mainThread
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : SingleObserver<Episodes> {
                    override fun onSuccess(t: Episodes) {
                        /*Your logic of setting UI goes here*/
                        loading.visibility = View.GONE

                        if (t.response.equals("true", true)) {

                            val adapter = EpisodeListAdapter(this@MainActivity, t.episodes!!)
                            val manager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

                            recyclerView.adapter = adapter
                            recyclerView.layoutManager = manager
                            recyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

                            recyclerView.visibility = View.VISIBLE
                            fetchButton.visibility = View.GONE

                        }
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        loading.visibility = View.GONE
                        e.printStackTrace()
                        Toast.makeText(this@MainActivity, "Some error", Toast.LENGTH_SHORT).show()
                    }

                })

    }
}
