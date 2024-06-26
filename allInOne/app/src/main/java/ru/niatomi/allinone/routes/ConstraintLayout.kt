package ru.niatomi.allinone.routes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId

@Composable
fun ConstraintLayoutScreen() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)

            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }

    }
    ConstraintLayout(constraints, Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(Color.Green).layoutId("greenBox"))
        Box(modifier = Modifier.background(Color.Red).layoutId("redBox"))
    }
}