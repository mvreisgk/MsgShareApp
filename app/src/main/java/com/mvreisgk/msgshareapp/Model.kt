package com.mvreisgk.msgshareapp

data class Hobby(var title: String)

object Supplier {
    val hobbies = listOf<Hobby>(
        Hobby("Swimming"),
        Hobby("Reading"),
        Hobby("Writing"),
        Hobby("Processing"),
        Hobby("Naming"),
        Hobby("Typing"),
        Hobby("Thinking"),
        Hobby("Doing"),
        Hobby("Studying"),
        Hobby("Making"),
    )
}