package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Column(
            modifier = Modifier
                .background(Color(0xFF495E57))
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4CE14),
                onTextLayout = {}
            )
            Text(
                text = stringResource(id = R.string.location),
                fontSize = 24.sp,
                color = Color(0xFFEDEFEE),
                onTextLayout = {}
            )
            Row(
                modifier = Modifier
                    .padding(top = 18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    color = Color(0xFFEDEFEE),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 28.dp)
                        .fillMaxWidth(0.6f),
                    onTextLayout = {}
                )
                Image(
                    painter = painterResource(id = R.drawable.upperpanelimage),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                )
            }
            Button(
                onClick = { navController.navigate(Menu.route)},
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14))
            ) {
                Text(
                    text = stringResource(id = R.string.orderbuttontext),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333),
                    onTextLayout = {}
                )
            }
        }
        LowerPanel()
    }
}

@Composable
fun TopAppBar() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu Icon"
            )
        }

        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(.32f)
                .align(Alignment.Center)
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_basket),
                    contentDescription = "Basket"
                )
            }
        }
    }
}


@Composable
private fun LowerPanel() {
    Column {
        WeeklySpecialCard()
        MenuDish()
    }
}


@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp),
            onTextLayout = {}
        )
    }
}


@Composable
fun MenuDish() {
    Column(Modifier.verticalScroll(rememberScrollState())){
        Dishes.forEach(){Dish ->
            MenuDish(Dish)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview() {
    LowerPanel()
}
