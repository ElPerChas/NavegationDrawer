package com.example.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pantalla1(productos:ArrayList<Productos>) {
    LazyColumn() {
        items(productos) { item: Productos ->
            if (item.categoria.equals("Hogar")) {
                var isExpanded by remember { mutableStateOf(false) }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, color = Color.Black)
                        .padding(15.dp)
                        .background(Color.LightGray)
                        .clickable {
                            isExpanded = !isExpanded
                        }
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = item.imagen),
                            contentDescription = "",
                            modifier = Modifier
                                .size(350.dp)
                                .padding(top = 0.dp, bottom = 5.dp, start = 10.dp, end = 5.dp)
                        )
                        if (isExpanded) {
                            Text(
                                text = item.descripcion,
                                fontSize = 18.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
                            )
                        } else {
                            Text(
                                text = item.nombre,
                                fontSize = 28.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
                            )
                            Text(
                                text = "${Math.round(item.precio)} €",
                                fontSize = 35.sp,
                                modifier = Modifier.padding(bottom = 30.dp, start = 10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}