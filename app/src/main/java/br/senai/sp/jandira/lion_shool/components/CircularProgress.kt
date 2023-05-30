import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CircularProgressBar(progress: Float, strokeWidth: Dp = 4.dp, color: Color) {
    val grayColor = Color.LightGray

    Box(
        modifier = Modifier.size(64.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier
                .size(64.dp)
                .padding(16.dp),
            color = color, // Customize the color here
            strokeWidth = strokeWidth // Customize the thickness here
        )

        val remainingProgress = 1f - progress
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Adjust padding to match the progress indicator
        ) {
            val radius = (size.minDimension - strokeWidth.toPx()) / 2f
            val center = Offset(size.width / 2f, size.height / 2f)
            val startAngle = (progress * 360f) - 90f
            val sweepAngle = remainingProgress * 360f

            rotate(startAngle, center) {
                drawArc(
                    color = grayColor, // Set the color for the remaining portion
                    startAngle = 0f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = strokeWidth.toPx())
                )
            }
        }

        Text(
            text = (progress * 100).toInt().toString(),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}