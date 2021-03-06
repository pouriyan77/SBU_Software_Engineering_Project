package ir.sbu.softwareengineering_proposal.adapter

import androidx.recyclerview.widget.RecyclerView
import android.graphics.Rect
import android.view.View


class HorizontalSpacingItemDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = padding
        outRect.left = padding
    }
}