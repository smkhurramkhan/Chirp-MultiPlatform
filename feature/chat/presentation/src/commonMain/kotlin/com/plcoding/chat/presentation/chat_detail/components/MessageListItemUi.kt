package com.plcoding.chat.presentation.chat_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.chat.domain.models.ChatMessageDeliveryStatus
import com.plcoding.chat.presentation.model.MessageUi
import com.plcoding.core.designsystem.components.avatar.ChatParticipantUi
import com.plcoding.core.designsystem.theme.ChirpTheme
import com.plcoding.core.designsystem.theme.extended
import com.plcoding.core.presentation.util.UiText
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MessageListItemUi(
    messageUi: MessageUi,
    onMessageLongClick : () -> Unit,
    onDismissMessageMenu : () -> Unit,
    onDeleteClick : () -> Unit,
    onRetryClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        when (messageUi) {
            is MessageUi.DateSeparator -> {
                DateSeparator(
                    date = messageUi.date.asString(),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            is MessageUi.LocalUserMessage -> LocalUserMessage(
                message = messageUi,
                onMessageLongClick = onMessageLongClick,
                onDismissMessageMenu = onDismissMessageMenu,
                onDeleteClick = onDeleteClick,
                onRetryClick = onRetryClick
            )
            is MessageUi.OtherUserMessage -> OtherUserMessage(message = messageUi)
        }
    }
}


@Composable
private fun DateSeparator(
    date: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f))
        Text(
            text = date,
            modifier = Modifier.padding(horizontal = 40.dp),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.extended.textPlaceholder
        )
        HorizontalDivider(modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview
private fun LocalUserMessageSendingPreview() {
    ChirpTheme {
        MessageListItemUi(
            messageUi = MessageUi.LocalUserMessage(
                id = "1",
                content = "Hello World, this is a preview Message that spans multiple lines.",
                deliveryStatus = ChatMessageDeliveryStatus.SENDING,
                isMenuOpen = false,
                formattedSentTime = UiText.DynamicString("Friday 2:20 pm")
            ),
            onDeleteClick = {},
            onDismissMessageMenu = {},
            onRetryClick = {},
            onMessageLongClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
@Preview
private fun LocalUserMessageRetryPreview() {
    ChirpTheme(darkTheme = true) {
        MessageListItemUi(
            messageUi = MessageUi.LocalUserMessage(
                id = "1",
                content = "Hello World, this is a preview Message that spans multiple lines.",
                deliveryStatus = ChatMessageDeliveryStatus.FAILED,
                isMenuOpen = false,
                canRetry = true,
                formattedSentTime = UiText.DynamicString("Friday 2:20 pm")
            ),
            onDeleteClick = {},
            onDismissMessageMenu = {},
            onRetryClick = {},
            onMessageLongClick = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@Composable
@Preview
private fun LocalUserMessageSentPreview() {
    ChirpTheme {
        MessageListItemUi(
            messageUi = MessageUi.LocalUserMessage(
                id = "1",
                content = "Hello World, this is a preview Message that spans multiple lines.",
                deliveryStatus = ChatMessageDeliveryStatus.SENT,
                isMenuOpen = false,
                formattedSentTime = UiText.DynamicString("Friday 2:20 pm")
            ),
            onDeleteClick = {},
            onDismissMessageMenu = {},
            onRetryClick = {},
            onMessageLongClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}


@Composable
@Preview
private fun OtherMessagePreview() {
    ChirpTheme {
        MessageListItemUi(
            messageUi = MessageUi.OtherUserMessage(
                id = "1",
                content = "Hello World, this is a preview Message that spans multiple lines.",
                formattedSentTime = UiText.DynamicString("Friday 2:20 pm"),
                sender = ChatParticipantUi(
                    id = "1",
                    username = "S M Khurram Khan",
                    initials = "SM"
                )
            ),
            onDeleteClick = {},
            onDismissMessageMenu = {},
            onRetryClick = {},
            onMessageLongClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}