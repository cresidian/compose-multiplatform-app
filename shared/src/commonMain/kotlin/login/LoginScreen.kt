package login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun loginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource("ic-logo.xml"), null)
            //Image(painterResource("compose-multiplatform.xml"), null)
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Login to your account - enjoy exclusive features and many more",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = { email = it },
                placeholder = { Text("Email", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email",
                        tint = Color.Gray
                    )
                },
                //textStyle = TextStyle.Default.copy(fontSize = 14.sp),
                modifier = Modifier.fillMaxWidth().heightIn(min = 42.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { newText ->
                    password = newText
                },
                placeholder = { Text("Password", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Password",
                        tint = Color.Gray
                    )
                },
                //textStyle = TextStyle.Default.copy(fontSize = 14.sp),
                modifier = Modifier.fillMaxWidth().heightIn(min = 42.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Forgot Password?",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.End),
                color = Color(0xFF37CC63)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth().height(42.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF37CC63),
                    contentColor = Color.White
                )
            ) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(20.dp))
            dividerWithText()
            Spacer(modifier = Modifier.height(20.dp))
            googleButton()
        }
    }

}

@Composable
private fun dividerWithText() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "OR", color = Color.Gray)
        Spacer(modifier = Modifier.width(10.dp))
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun googleButton() {
    OutlinedButton(onClick = {

    }, modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            /*Icon(
                imageVector = ImageVector("ic-google.xml"),
                contentDescription = "Google Sign In",
            )*/
            Image(painterResource("ic-google.xml"), null)
            Text("Continue with Google", color = Color.Gray)
        }
    }
}