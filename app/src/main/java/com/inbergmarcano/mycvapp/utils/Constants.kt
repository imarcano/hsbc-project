package com.inbergmarcano.mycvapp.utils

class Constants {

    companion object{

        private val PROTOCOL = "https://"
        val BASE_URL = PROTOCOL + "api.bitbucket.org/2.0/"
    }

        class Preferences {

            companion object{
                val TOKEN = "token"
                val BEARER = "Bearer"
            }

        }

        class HTTPHeaders {

            companion object{
                val AUTHORIZATION = "Authorization"
                val ACCEPT = "Accept"
            }

        }
}