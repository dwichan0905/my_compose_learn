package idn.dwichan.gmailclone.model

data class EmailModel(
    val contentMail: String,
    val email: String,
    val id: String,
    val sender: String,
    val time: String,
    val title: String,
    val isRead: Boolean,
    val isStarred: Boolean
)
