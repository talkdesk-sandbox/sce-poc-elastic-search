package com.studiobff.studiobfftest.models


data class Filters(
    val order_by: String,
    val page: Int,
    val per_page: Int
);