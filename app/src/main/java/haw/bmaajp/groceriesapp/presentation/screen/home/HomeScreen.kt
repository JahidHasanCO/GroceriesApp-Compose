package haw.bmaajp.groceriesapp.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.presentation.common.content.ListContentProduct
import haw.bmaajp.groceriesapp.presentation.component.SearchViewBar
import haw.bmaajp.groceriesapp.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold {
        Home()
    }
}

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    // TODO: Delete Again
    val products = listOf(
        ProductItem(
            id = 1,
            title = "Salmond",
            description = "",
            image = R.drawable.product9,
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0
        ),
        ProductItem(
            id = 1,
            title = "Orange",
            description = "",
            image = R.drawable.product8,
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0
        ),
        ProductItem(
            id = 1,
            title = "Organic Bananas",
            description = "",
            image = R.drawable.product10,
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0
        )
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HeaderLocationHome()

        SearchViewBar()

        ListContentProduct(
            title = stringResource(id = R.string.exclusive_offer),
            products = products
        )

        Spacer(modifier = Modifier.height(DIMENS_24dp))

        ListContentProduct(
            title = stringResource(id = R.string.best_selling),
            products = products.shuffled()
        )

    }
}

@Composable
fun HeaderLocationHome() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(DIMENS_32dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_nectar),
            contentDescription = stringResource(id = R.string.logo_app),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = stringResource(R.string.image_location),
                tint = GrayThirdTextColor
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(R.string.sample_country),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = GrayThirdTextColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderLocationHomePreview() {
    HeaderLocationHome()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Home()
}