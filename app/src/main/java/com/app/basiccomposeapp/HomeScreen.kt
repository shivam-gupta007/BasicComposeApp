package com.app.basiccomposeapp

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(list: List<Int> = List(100) { it }) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        items(list) {
            MyCard(
                id = it.toString()
            )
        }
    }
}


@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    id: String
) {

    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        color = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = modifier
                .padding(24.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(
                    text = id, style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if(expanded){
                    Text(
                        text = stringResource(R.string.lorem_ipsum)
                    )
                }
            }

            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded) stringResource(R.string.show_more) else stringResource(R.string.show_less)
                )
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 300)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}