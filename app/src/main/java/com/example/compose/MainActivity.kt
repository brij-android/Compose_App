package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.compose.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

data class Info(
    val userName: String,
    val imgUrl: String,
    val isVerified: Boolean
)

@Composable
fun MainScreen() {
    LazyColumn(modifier = Modifier.background(color = Color.LightGray),
        state = rememberLazyListState(),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        userScrollEnabled = true) {
        val dogBreedsList: List<Info> = listOf(
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
            Info("Airedale", "https://images.dog.ceo/breeds/airedale/n02096051_1110.jpg", true),
            Info("Affepinscher", "https://images.dog.ceo/breeds/affenpinscher/n02110627_10437.jpg", true),
            Info("African", "https://images.dog.ceo/breeds/african/n02116738_10038.jpg", false),
        )
        items(dogBreedsList) {
            GreetingCard(it)
        }

    }
    /*Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)) {
        GreetingCard()
//        StatefulView()
//        StatelessView()
    }*/
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GreetingCard(info: Info) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp, 8.dp),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Box {
//                val image: Painter = rememberAsyncImagePainter(info.imgUrl)
                GlideImage(
//                    painter = image,
                    model = info.imgUrl,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(40.dp)),
                    contentDescription = "Test Image",
                    contentScale = ContentScale.Crop
                )
                /*Icon(
                    Icons.Filled.Person,
                    contentDescription = "front",
                    Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                        .size(80.dp),
                    tint = Color.White
                )*/
                if (info.isVerified)
                    Icon(
                        Icons.Filled.Favorite, contentDescription = "check",
                        Modifier
                            .align(Alignment.BottomEnd)
                            .padding(0.dp),
                        tint = Color.Magenta
                    )
            }
            Column(Modifier.padding(16.dp)) {
                Text(text = info.userName, fontSize = 24.sp, color = Color.Black)
                Text(text = "4 min ago", fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}


@Composable
fun StatefulView() {
    var value by remember {
        mutableStateOf(false)
    }
    Button(
        onClick = { value = !value },
        modifier = Modifier.padding(8.dp),
        shape = ButtonDefaults.elevatedShape
    ) {
        Text(text = "$value".uppercase())
    }

}

@Composable
fun StatelessView() {
    var name by remember {
        mutableStateOf("")
    }

    NameContent(
        name = name,
        onNameChange = { name = it }
    )

}

@Composable
fun NameContent(name: String, onNameChange: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        modifier = Modifier.padding(8.dp),
        label = { Text(text = "Name") })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        MainScreen()
    }
}