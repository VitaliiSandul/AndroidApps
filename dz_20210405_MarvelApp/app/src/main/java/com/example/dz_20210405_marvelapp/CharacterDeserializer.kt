package com.example.dz_20210405_marvelapp

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class CharacterDeserializer : JsonDeserializer<ArrayList<Character>> {
    override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
    ): ArrayList<Character> {

        val characterJsonObject = json?.asJsonObject
        val jsonArray = characterJsonObject?.get("data")?.asJsonObject?.get("results")?.asJsonArray

        var characters = ArrayList<Character>()

        if (jsonArray != null) {
            for (elem in jsonArray) {
                val thumbnail = elem.asJsonObject.get("thumbnail").asJsonObject
                characters.add(
                        Character(
                                elem.asJsonObject.get("name").asString,
                                "${thumbnail.get("path").asString}.${thumbnail.asJsonObject.get("extension").asString}"
                        )
                )
            }
        }

        return characters
    }

}