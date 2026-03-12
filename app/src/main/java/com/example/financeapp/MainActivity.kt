package com.example.financeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financeapp.components.SeccionTarjetas
import com.example.financeapp.components.SeccionTransacciones
import com.example.financeapp.models.usuario
import com.example.financeapp.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    val colors = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(innerPadding)
            .padding(horizontal = 16.dp)
    ) {
        Header()
        SeccionTarjetas()
        SeccionTransacciones()
    }
}

@Composable
fun Header() {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom  = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row ( // Avatar info
             verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "avatar",
                tint = colors.onPrimary,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(colors.primary)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "Hola ${usuario.nombre}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = colors.onBackground
                )
                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.onSurfaceVariant
                )
            }
        }
        Icon( //el icono hamburguesa
            imageVector = Icons.Default.Menu,
            contentDescription = "menu",
            tint = colors.onBackground,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    FinanceAppTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}
