package com.example.dz_20210405_marvelapp.api

import com.example.dz_20210405_marvelapp.models.Character
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class CharacterDeserializer : JsonDeserializer<SizeAndArrayCharacters> {
    override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
    ): SizeAndArrayCharacters {

        val characterJsonObject = json?.asJsonObject
        val jsonArray = characterJsonObject?.get("data")?.asJsonObject?.get("results")?.asJsonArray

        var total = characterJsonObject?.get("data")?.asJsonObject?.get("total")?.asInt
        var characters = ArrayList<Character>()

        if (jsonArray != null) {
            for (elem in jsonArray) {
                val thumbnail = elem.asJsonObject.get("thumbnail").asJsonObject
                characters.add(
                    Character(
                        elem.asJsonObject.get("id").asInt,
                        elem.asJsonObject.get("name").asString,
                        "${thumbnail.get("path").asString}.${thumbnail.asJsonObject.get("extension").asString}"
                    )
                )
            }
        }


        return SizeAndArrayCharacters(total, characters)
    }

}