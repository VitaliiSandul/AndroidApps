package com.example.dz_20210405_marvelapp.api

import android.util.Log
import com.example.dz_20210405_marvelapp.models.Character
import com.example.dz_20210405_marvelapp.models.Comic
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ComicDeserializer : JsonDeserializer<ArrayList<Comic>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ArrayList<Comic> {

        val comicJsonObject = json?.asJsonObject
        val jsonArray = comicJsonObject?.get("data")?.asJsonObject?.get("results")?.asJsonArray

        var comics = ArrayList<Comic>()

        if (jsonArray != null) {
            for (elem in jsonArray) {

                var comicTitle = elem.asJsonObject.get("title").asString
                var comicDescription = elem.asJsonObject.get("description").toString()

                if(comicDescription == "null"){
                    comicDescription = "No description"
                }
                comics.add(Comic(comicTitle, comicDescription))
            }
        }

        return comics
    }
}