package com.sinaseyfi.presentation.ui.crypto.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.sinaseyfi.presentation.theme.*
import com.sinaseyfi.presentation.ui.base.BaseComposeFragment
import com.sinaseyfi.presentation.ui.crypto.CryptoViewModel
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import com.sinaseyfi.presentation.ui.factories.SortAttributeTextFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat

@AndroidEntryPoint
class CryptoListFragment: BaseComposeFragment() {

    @ExperimentalMaterialApi
    @ExperimentalUnitApi
    @Composable
    override fun ShowUI() {
        CryptoListScreen()
    }

}

@ExperimentalMaterialApi
@ExperimentalUnitApi
@Composable
fun CryptoListScreen() {
    CryptoListSampleTheme {
        Surface(
            color = Color.White
        ) {
            val scope = rememberCoroutineScope()
            val modalState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
            val viewModel: CryptoViewModel = viewModel()
            val viewState = viewModel.viewState.collectAsState()
            val lazyPagingItems = viewModel.getCryptoPagedList(
                viewState.value.sortAttribute,
                viewState.value.sortDirDataModel
            ).collectAsLazyPagingItems()
            ModalBottomSheetLayout(
                sheetState = modalState,
                sheetContent = {
                    LazyColumn {
                        itemsIndexed(CryptoSortAttributeDataModel.values()) { _, item ->
                            ListItem(
                                text = { Text(text = SortAttributeTextFactory.create(item)) },
                                modifier = Modifier.clickable {
                                    viewModel.setAttribute(item)
                                    scope.launch { modalState.hide() }
                                }
                            )
                        }
                    }
                }
            ) {
                Box {
                    LazyColumn(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(0.dp, 8.dp, 0.dp, 8.dp)) {
                        if(lazyPagingItems.loadState.refresh == LoadState.Loading) {
                            item {
                                Text(
                                    text = "Waiting for items to load from the backend",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.CenterHorizontally)
                                )
                            }
                        }
                        items(lazyPagingItems) { item ->
                            CryptoListItem(item)
                        }
                        if (lazyPagingItems.loadState.append == LoadState.Loading) {
                            item {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .height(56.dp + 56.dp)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 56.dp),
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = SortAttributeTextFactory.create(viewState.value.sortAttribute),
                                fontSize = TextUnit(14f, TextUnitType.Sp),
                                modifier = Modifier
                                    .padding(16.dp, 8.dp)
                                    .clickable { scope.launch { modalState.show() } },
                                textAlign = TextAlign.Start)
                            Icon(
                                if(viewState.value.sortDirDataModel == SortDirectionDataModel.ASC) Icons.Default.KeyboardArrowUp
                                else Icons.Default.KeyboardArrowDown,
                                contentDescription =
                                if(viewState.value.sortDirDataModel == SortDirectionDataModel.ASC) "Ascending"
                                else "Descending",
                                Modifier.clickable { viewModel.switchDirection() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
fun CryptoListItem(cryptoListingDataModel: CryptoListingDataModel?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(136.dp)
            .padding(16.dp, 8.dp, 16.dp, 0.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 16.dp, topEnd = 32.dp, bottomEnd = 8.dp)
    ) {
        Box {
            val price = "${cryptoListingDataModel?.quote?.get("USD")?.price ?: 0.0}$"
            val marketCap = "${cryptoListingDataModel?.quote?.get("USD")?.marketCap ?: 0.0}$"
            val percentChange24h = cryptoListingDataModel?.quote?.get("USD")?.percentChange24h ?: 0.0
            Column(modifier = Modifier
                .padding(16.dp, 8.dp)
                .align(Alignment.TopStart), verticalArrangement = Arrangement.Center) {
                Text(text = cryptoListingDataModel?.symbol.toString(), fontSize = TextUnit(18f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
                Text(text = cryptoListingDataModel?.name.toString(), fontSize = TextUnit(14f, TextUnitType.Sp), fontWeight = FontWeight.Normal)
            }
            Column(modifier = Modifier
                .padding(16.dp, 0.dp, 0.dp, 16.dp)
                .align(Alignment.BottomStart), horizontalAlignment = Alignment.Start) {
                Text(text = "Price", fontSize = TextUnit(16f, TextUnitType.Sp), fontWeight = FontWeight.Normal, color = Green)
                Text(text = "Market Cap", fontSize = TextUnit(13f, TextUnitType.Sp), fontWeight = FontWeight.Light, color = Color.DarkGray)
            }
            Column(modifier = Modifier
                .padding(0.dp, 0.dp, 16.dp, 16.dp)
                .align(Alignment.BottomEnd), horizontalAlignment = Alignment.End) {
                Text(text = price, fontSize = TextUnit(16f, TextUnitType.Sp), fontWeight = FontWeight.Normal, color = Green)
                Text(text = marketCap, fontSize = TextUnit(13f, TextUnitType.Sp), fontWeight = FontWeight.Light, color = Color.DarkGray)
            }
            Column(modifier = Modifier.align(Alignment.TopEnd)) {
                Card(modifier = Modifier
                    .width(112.dp)
                    .height(48.dp)
                    .padding(0.dp, 16.dp, 16.dp, 0.dp),
                    backgroundColor = if(percentChange24h > 0.0) Teal50 else Red,
                    shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 8.dp, topEnd = 16.dp, bottomEnd = 4.dp),
                    elevation = 0.dp
                ) {
                    val amount = "${DecimalFormat("#.##")
                        .apply { roundingMode = RoundingMode.FLOOR }.format(percentChange24h)}$"
                    Text(text = if(percentChange24h > 0.0) "+$amount" else amount, modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight.Medium,
                        color = if(percentChange24h > 0.0) Teal500 else Color.White
                    )
                }
                Text(text = "last 24h",
                    fontSize = TextUnit(12f, TextUnitType.Sp),
                    fontWeight = FontWeight.Light,
                    color = (if(percentChange24h > 0.0) Teal500 else Red).copy(alpha = 0.65f),
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.End)
                        .padding(
                            end = 16.dp
                        )
                )
            }
        }
    }
}