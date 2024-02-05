package com.pbi.superherolists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pbi.superherolists.data.repository.Heroes
import com.pbi.superherolists.model.Hero
import com.pbi.superherolists.ui.theme.SuperHeroListsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar()
        },
        modifier = modifier
    ) {
        SuperheroesList(paddingValues = it)
    }
}

@Composable
fun SuperheroesList(paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        itemsIndexed(Heroes.heroes) { _, item ->
            SuperHeroCard(
                hero = item,
            )
        }
    }
}

@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        SuperheroesDetails(hero = hero)
    }
}

@Composable
fun SuperheroesDetails(hero: Hero, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
    ) {
        Column(
            modifier = modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = hero.nameRes),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(id = hero.descRes),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        SuperheroesImage(hero = hero)
    }
}

@Composable
fun SuperheroesImage(hero: Hero, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small)
    ){
        Image(
            painter = painterResource(id = hero.drawableRes),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun GreetingPreview() {
    SuperHeroListsTheme {
        SuperHeroApp()
    }
}