package com.teaphy.customcomponent.itemDecoration.decoration

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @Desc:
 * @author tiany
 * @time  2021-01-28  11:48
 * @version 1.0
 */
class GridItemDecoration(
    private val horizontalSpace: Int,
    private val verticalSpace: Int,
    private val spanCount: Int
) :
    RecyclerView.ItemDecoration() {

    constructor(horizontalSpace: Int, verticalSpace: Int) : this(horizontalSpace, verticalSpace, 1)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutManager: RecyclerView.LayoutManager = parent.layoutManager
            ?: throw IllegalStateException("LayoutManager isn't set.")

        val position = parent.getChildLayoutPosition(view)

        configGridDecoration(outRect, position, state.itemCount)
    }

    private fun configGridDecoration(outRect: Rect, position: Int, totalCount: Int) {

        // 所在的列
        val column = position % spanCount
        // column * (列间距 * (1f / 列数))
        outRect.left = column * horizontalSpace / spanCount
        // 列间距 - (column + 1) * (列间距 * (1f /列数))
        outRect.right = horizontalSpace - (column + 1) * horizontalSpace / spanCount


        // 当前列
        val currentColumn = position % spanCount
        // 计算总行数
        val rows = if (totalCount % spanCount != 0) {
            (totalCount / spanCount) + 1
        } else {
            totalCount / spanCount
        }

        Log.e(
            "teaphy",
            "configGridDecoration, position: $position, totalCount: $totalCount, rows: $rows, currentRow: ${position / spanCount}"
        )

        // 计算当前行数
        when (position / spanCount) {
            0 -> { // 第一行
                when (currentColumn) {
                    0 -> {
                        with(outRect) {
                            left = horizontalSpace
                            right = horizontalSpace / 2
                            bottom = verticalSpace / 2
                            top = verticalSpace
                        }
                    }
                    spanCount - 1 -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace
                            bottom = verticalSpace / 2
                            top = verticalSpace
                        }
                    }
                    else -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace / 2
                            bottom = verticalSpace / 2
                            top = verticalSpace
                        }
                    }
                }
            }
            rows - 1 -> {
                when (currentColumn) {
                    0 -> {
                        with(outRect) {
                            left = horizontalSpace
                            right = horizontalSpace / 2
                            bottom = verticalSpace
                            top = verticalSpace / 2
                        }
                    }
                    spanCount - 1 -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace
                            bottom = verticalSpace
                            top = verticalSpace / 2
                        }
                    }
                    else -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace / 2
                            bottom = verticalSpace
                            top = verticalSpace / 2
                        }
                    }
                }
            }
            else -> {
                when (currentColumn) {
                    0 -> {
                        with(outRect) {
                            left = horizontalSpace
                            right = horizontalSpace / 2
                            bottom = verticalSpace / 2
                            top = verticalSpace / 2
                        }
                    }
                    spanCount - 1 -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace
                            bottom = verticalSpace / 2
                            top = verticalSpace / 2
                        }
                    }
                    else -> {
                        with(outRect) {
                            left = horizontalSpace / 2
                            right = horizontalSpace / 2
                            bottom = verticalSpace / 2
                            top = verticalSpace / 2
                        }
                    }
                }
            }
        }

    }

}