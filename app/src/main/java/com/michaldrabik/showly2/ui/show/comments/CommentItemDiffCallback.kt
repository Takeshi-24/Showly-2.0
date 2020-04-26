package com.michaldrabik.showly2.ui.show.comments

import androidx.recyclerview.widget.DiffUtil
import com.michaldrabik.showly2.model.Comment

class CommentItemDiffCallback : DiffUtil.ItemCallback<Comment>() {

  override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
    oldItem.id == newItem.id

  override fun areContentsTheSame(oldItem: Comment, newItem: Comment) =
    oldItem == newItem
}
