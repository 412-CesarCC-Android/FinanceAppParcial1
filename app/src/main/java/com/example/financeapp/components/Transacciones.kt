package com.example.financeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.financeapp.models.Transaction
import com.example.financeapp.models.transacciones

@Composable
fun SeccionTransacciones() {
    val colors = MaterialTheme.colorScheme

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Transactions",
                style = MaterialTheme.typography.titleLarge,
                color = colors.onBackground
            )
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(transacciones) { transaccion ->
                ItemTransaccion(transaccion = transaccion)
            }
        }
    }
}

@Composable
fun ItemTransaccion(transaccion : Transaction) {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(vertical  = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = transaccion.categoria,
                tint = colors.onPrimary,
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(colors.primary)
                    .padding(10.dp)
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = transaccion.nombre,
                    style = MaterialTheme.typography.bodyLarge,
                    color = colors.onBackground
                )
                Text(
                    text = transaccion.categoria,
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.onSurfaceVariant
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = if(transaccion.monto < 0) "$${transaccion.monto}" else "$${"%.2f".format(transaccion.monto)}",
                style = MaterialTheme.typography.bodyLarge,
                color = colors.onBackground
            )
            Text(
                text= transaccion.hora,
                style = MaterialTheme.typography.bodySmall,
                color = colors.onSurfaceVariant
            )
        }
    }
}
