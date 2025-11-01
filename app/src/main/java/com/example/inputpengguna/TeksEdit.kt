package com.example.inputpengguna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val perkawinan = listOf("Janda", "Lajang", "Duda")

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF9C27B0), Color(0xFFE1BEE7))
    )

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(gradient)
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Pendaftaran",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {

                Text(text = "NAMA LENGKAP", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it },
                    label = { Text("Isian nama lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "JENIS KELAMIN", fontWeight = FontWeight.Bold)
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = (textJK == item),
                                onClick = { textJK = item }
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (textJK == item),
                            onClick = { textJK = item }
                        )
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
                perkawinan.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = (textStatus == item),
                                onClick = { textStatus = item }
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (textStatus == item),
                            onClick = { textStatus = item }
                        )
                        Text(item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "ALAMAT", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    label = { Text("Alamat") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    enabled = textAlamat.isNotEmpty(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3F51B5),
                        contentColor = Color.White
                    ),
                    onClick = {
                        nama = textNama
                        jenis = textJK
                        status = textStatus
                        alamat = textAlamat
                    }
                ) {
                    Text("Submit", fontWeight = FontWeight.Bold)
                }
            }
        }

        if (nama.isNotEmpty() && jenis.isNotEmpty() && status.isNotEmpty() && alamat.isNotEmpty()) {
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color.DarkGray
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .height(120.dp)
                    .width(300.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
                ) {
                    Text(text = "Nama   : "+nama, color = Color.White )
                    Text(text = "Gender : "+jenis, color = Color.White )
                    Text(text = "Status : "+status, color = Color.White )
                    Text(text = "Alamat : "+alamat, color = Color.White)

                }
            }
        }


        Spacer(modifier = Modifier.height(32.dp))
    }
}
