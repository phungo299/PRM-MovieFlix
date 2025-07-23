package com.example.moviesapp.auth.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var confirmPasswordHidden by rememberSaveable { mutableStateOf(true) }

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF1C1C1E)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MovieApp",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF8A2BE2)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Đăng ký tài khoản mới",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Tạo tài khoản để xem phim không giới hạn",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))

            // Name Field
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Họ và tên") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    containerColor = Color(0xFF2C2C2E),
                    focusedBorderColor = Color(0xFF8A2BE2),
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email hoặc số điện thoại") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    containerColor = Color(0xFF2C2C2E),
                    focusedBorderColor = Color(0xFF8A2BE2),
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mật khẩu") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        Icon(imageVector = visibilityIcon, contentDescription = null, tint = Color.Gray)
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    containerColor = Color(0xFF2C2C2E),
                    focusedBorderColor = Color(0xFF8A2BE2),
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            // Confirm Password Field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Xác nhận mật khẩu") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordHidden = !confirmPasswordHidden }) {
                        val visibilityIcon = if (confirmPasswordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        Icon(imageVector = visibilityIcon, contentDescription = null, tint = Color.Gray)
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    containerColor = Color(0xFF2C2C2E),
                    focusedBorderColor = Color(0xFF8A2BE2),
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Register Button
            Button(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8A2BE2))
            ) {
                Text("Đăng ký", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Login Link
            Row {
                Text("Đã có tài khoản? ", color = Color.Gray)
                Text(
                    "Đăng nhập ngay",
                    modifier = Modifier.clickable(onClick = onLoginClick),
                    color = Color(0xFF8A2BE2),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
} 