package com.sample.sampleretrofil_kotlin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * You can obtain POJO class from below website, you need to paste sample Json data
 *  * @see <a href="http://www.jsonschema2pojo.org/">JsonSchemaToPojo website</a>
 */

class Episodes {

    @SerializedName("Title")
    @Expose
    var title: String? = null
    @SerializedName("Season")
    @Expose
    var season: String? = null
    @SerializedName("totalSeasons")
    @Expose
    var totalSeasons: String? = null
    @SerializedName("Episodes")
    @Expose
    var episodes: ArrayList<Episode>? = null
    @SerializedName("Response")
    @Expose
    var response: String? = null


    inner class Episode {

        @SerializedName("Title")
        @Expose
        var title: String? = null
        @SerializedName("Released")
        @Expose
        var released: String? = null
        @SerializedName("Episode")
        @Expose
        var episode: String? = null
        @SerializedName("imdbRating")
        @Expose
        var imdbRating: String? = null
        @SerializedName("imdbID")
        @Expose
        var imdbID: String? = null

    }
}