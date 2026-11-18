package com.alitamim.alivpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection

private val Gold = Color(0xFFD4AF37)
private val Background = Color(0xFF090909)
private val Panel = Color(0xFF171717)
private val Muted = Color(0xFFAAAAAA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    AliVpnHome()
                }
            }
        }
    }
}

@Composable
private fun AliVpnHome() {
    var isRequested by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("♛", color = Gold, fontSize = 42.sp)
            Text(
                "AliVPN",
                color = Gold,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text("اتصال امن، ساده و سریع", color = Muted, fontSize = 14.sp)
            Spacer(Modifier.height(54.dp))

            Box(
                modifier = Modifier
                    .size(190.dp)
                    .background(Panel, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(156.dp)
                        .background(Color(0xFF242016), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("AV", color = Gold, fontSize = 44.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(28.dp))
            Text(
                if (isRequested) "درخواست اتصال ثبت شد" else "هنوز متصل نیستید",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "موتور اتصال VPN هنوز پیکربندی نشده است",
                color = Muted,
                fontSize = 12.sp
            )
            Spacer(Modifier.height(28.dp))

            Button(
                onClick = { isRequested = !isRequested },
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gold,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    if (isRequested) "لغو درخواست آزمایشی" else "اتصال آزمایشی",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(Modifier.height(24.dp))
            InfoRow("سرور", "انتخاب نشده")
            InfoRow("پروتکل", "در انتظار پیکربندی")
            InfoRow("اشتراک", "رایگان")
            Spacer(Modifier.weight(1f))
            Text(
                "ALI TAMIM  •  VERSION 0.1.0",
                color = Muted,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
            .background(Panel, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = Muted, fontSize = 13.sp)
        Text(value, color = Color.White, fontSize = 13.sp)
    }
}
