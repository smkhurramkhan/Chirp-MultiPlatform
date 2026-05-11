package com.plcoding.core.designsystem.components.avatar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plcoding.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChirpStackedAvatars(
    avatars:List<ChatParticipantUi>,
    modifier: Modifier = Modifier,
    size: AvatarSize = AvatarSize.SMALL,
    maxVisible:Int  = 2,
    overlapPercentage: Float  = 0.4f
){
    val overlapOffset = -(size.dp * overlapPercentage)

    val visibleAvatars = avatars.take(maxVisible)
    val remainingCount = (avatars.size- maxVisible).coerceAtLeast(0)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(overlapOffset),
        verticalAlignment = Alignment.CenterVertically
    ) {
        visibleAvatars.forEach { avatarUi ->
            ChirpAvatarPhoto(
                displayText = avatarUi.initials,
                size = size,
                imageUrl = avatarUi.imageUrl
            )
        }
        if(remainingCount>0){
            ChirpAvatarPhoto(
                displayText = "$remainingCount+",
                size = AvatarSize.SMALL,
                imageUrl = null,
                textColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Composable
@Preview
private fun ChirpStackedAvatarsPreview(){
    ChirpTheme {
        ChirpStackedAvatars(
            avatars = listOf(
                ChatParticipantUi(
                    id = "1",
                    username = "Phillip",
                    initials = "PH"
                ),
                ChatParticipantUi(
                    id = "2",
                    username = "Khurram",
                    initials = "SM"
                ),
                ChatParticipantUi(
                    id = "1",
                    username = "Cinderalla",
                    initials = "CI"
                ),
                ChatParticipantUi(
                    id = "1",
                    username = "John Deer",
                    initials = "JD"
                )
            )
        )
    }
}