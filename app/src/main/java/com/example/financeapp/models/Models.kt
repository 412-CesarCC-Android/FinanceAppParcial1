package com.example.financeapp.models

import androidx.compose.ui.graphics.Color

data class User(
    val nombre: String,
    val saldo: Double
)

data class SummaryCard(
    val titulo: String,
    val monto: String,
    val color: Color
)

data class Transaction(
    val nombre: String,
    val categoria: String,
    val monto: Double,
    val hora: String,
)

val usuario = User(
    nombre = "Vrad",
    saldo = 1500.00
)

val summaryCards = listOf(
    SummaryCard(
        titulo = "Actividad",
        monto  = "$280.99",
        color = Color(0xFFE6F2ED)
    ),
    SummaryCard(
        titulo = "Ventas",
        monto = "$280.99",
        color = Color(0xFFF5EFE6)
    ),
    SummaryCard(
        titulo = "Ganancias",
        monto = "$280.99",
        color = Color(0xFFEDE7F6)
    )
)

val transacciones = listOf(
    Transaction(nombre = "Supermarket", categoria = "Groceries", monto = 45.99, hora = "10:30 AM"),
    Transaction(nombre = "Gas Station", categoria = "Fuel", monto = -30.5, hora = "12:15 PM"),
    Transaction(nombre = "Coffee Shop", categoria = "Food & Drinks", monto = 5.75, hora = "8:00 AM"),
    Transaction(nombre = "Electronics Store", categoria = "Electronics", monto = 120.0, hora = "3:45 PM"),
    Transaction(nombre = "Bookstore", categoria = "Books", monto = 25.99, hora = "2:00 PM"),
    Transaction(nombre = "Restaurant", categoria = "Dining", monto = 60.0, hora = "7:30 PM")
)
