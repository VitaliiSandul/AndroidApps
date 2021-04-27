package com.example.dz_20210405_marvelapp.api

import com.example.dz_20210405_marvelapp.extensions.md5

class MarvelApiConfig {
    companion object {
        val publicKey = "322b60a20059ce155a9be11c0e0bac81"
        val privateKey = "4844d8584d6e638d9d8b56cde4a1fa2329f5a5bd"
        val ts = System.currentTimeMillis()
        val hash = "$ts$privateKey$publicKey".md5
    }
}