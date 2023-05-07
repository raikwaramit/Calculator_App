package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState, modifier: Modifier = Modifier, buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit,
) {
    @Composable
    fun RowScope.Button(
        symbol: String,
        size: Float = 1f,
        color: Color = Color.Gray,
        action: CalculatorAction,
    ) {
        CalculatorButton(symbol = symbol,
            modifier = Modifier
                .background(color)
                .aspectRatio(size)
                .weight(size),
            onClick = { onAction(action) })
    }

    @Composable
    fun FirstRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Button("AC", 2f, action = CalculatorAction.Clear)
            Button("Del", 1f, action = CalculatorAction.Delete)
            Button(
                "/",
                1f,
                color = Color.Yellow,
                action = CalculatorAction.Operation(CalculatorOperation.Divide)
            )
        }
    }

    @Composable
    fun SecondRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Button("7", 1f, action = CalculatorAction.Number(7))
            Button("8", 1f, action = CalculatorAction.Number(8))
            Button("9", 1f, action = CalculatorAction.Number(9))
            Button(
                "x",
                1f,
                color = Color.Yellow,
                action = CalculatorAction.Operation(CalculatorOperation.Multiply)
            )
        }
    }

    @Composable
    fun ThirdRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Button("4", 1f, action = CalculatorAction.Number(4))
            Button("5", 1f, action = CalculatorAction.Number(5))
            Button("6", 1f, action = CalculatorAction.Number(6))
            Button(
                "-",
                1f,
                color = Color.Yellow,
                action = CalculatorAction.Operation(CalculatorOperation.Subtract)
            )
        }
    }


    @Composable
    fun FourthRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Button("1", 1f, action = CalculatorAction.Number(1))
            Button("2", 1f, action = CalculatorAction.Number(2))
            Button("3", 1f, action = CalculatorAction.Number(3))
            Button(
                "+",
                1f,
                color = Color.Yellow,
                action = CalculatorAction.Operation(CalculatorOperation.Add)
            )
        }
    }

    @Composable
    fun FifthRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Button("0", 2f, action = CalculatorAction.Number(0))
            Button(".", 1f, action = CalculatorAction.Decimal)
            Button(
                "=",
                1f,
                color = Color.Yellow,
                action = CalculatorAction.Calculate
            )
        }
    }

// Calculator UI.
    Box() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .then(modifier),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            FirstRow() // First row of the calculator.

            SecondRow() // Second row of the calculator.

            ThirdRow() // Third row of the calculator.

            FourthRow() // Fourth row of the calculator.

            FifthRow() // Fifth row of the calculator.
        }
    }
}