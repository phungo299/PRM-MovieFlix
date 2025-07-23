package com.example.moviesapp.core.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R

@Composable
fun IntroScreen(onGetInClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Ảnh tròn lớn với viền gradient
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .border(
                        width = 2.dp,
                        brush = Brush.sweepGradient(
                            listOf(
                                Color(0xFFEE0979),
                                Color(0xFF00F2FE),
                                Color(0xFFEE0979)
                            )
                        ),
                        shape = CircleShape
                    )
                    .padding(8.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Thay bằng ảnh thực tế nếu có
                    contentDescription = "Intro Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            // Tiêu đề
            Text(
                text = "Watch Videos in Virtual\nReality",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Mô tả nhỏ
            Text(
                text = "Download and watch offline wherever you are",
                color = Color.LightGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp),
            )
            Spacer(modifier = Modifier.height(60.dp))
            // Nút Get In với viền gradient
            OutlinedButton(
                onClick = onGetInClick,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(54.dp),
                shape = RoundedCornerShape(50),
                border = BorderStroke(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFEE0979), Color(0xFF00F2FE))
                    )
                )
            ) {
                Text(
                    text = "Get In MovieFlix",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
} 