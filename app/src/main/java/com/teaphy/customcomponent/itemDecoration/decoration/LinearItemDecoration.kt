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
class LinearItemDecoration(
    private val horizontalSpace: Int,
    private val verticalSpace: Int
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutManager: LinearLayoutManager = parent.layoutManager as? LinearLayoutManager
            ?: throw IllegalStateException("LayoutManager isn't set.")

        val position = parent.getChildLayoutPosition(view)

        when (layoutManager.orientation) {
            RecyclerView.HORIZONTAL -> configHorizontalDecoration(
                outRect,
                position,
                state.itemCount
            )
            RecyclerView.VERTICAL -> configVerticalDecoration(
                outRect,
                position,
                state.itemCount
            )
            else -> {
            }
        }

    }

    private fun configHorizontalDecoration(
        outRect: Rect,
        position: Int,
        totalCount: Int
    ) {
        when (position) {
            0 -> {
                with(outRect) {
                    left = horizontalSpace
                    right = horizontalSpace / 2
                    bottom = verticalSpace
                    top = verticalSpace
                }
            }
            totalCount - 1 -> {
                with(outRect) {
                    left = horizontalSpace / 2
                    right = horizontalSpace
                    bottom = verticalSpace
                    top = verticalSpace
                }
            }
            else -> {
                with(outRect) {
                    left = horizontalSpace / 2
                    right = horizontalSpace / 2
                    bottom = verticalSpace
                    top = verticalSpace
                }
            }
        }
    }

    private fun configVerticalDecoration(outRect: Rect, position: Int, totalCount: Int) {
        when (position) {
            0 -> {
                with(outRect) {
                    left = horizontalSpace
                    right = horizontalSpace
                    bottom = verticalSpace / 2
                    top = verticalSpace
                }
            }
            totalCount - 1 -> {
                with(outRect) {
                    left = horizontalSpace
                    right = horizontalSpace
                    bottom = verticalSpace
                    top = verticalSpace / 2
                }
            }
            else -> {
                with(outRect) {
                    left = horizontalSpace
                    right = horizontalSpace
                    bottom = verticalSpace / 2
                    top = verticalSpace / 2
                }
            }
        }
    }

    private fun configGridDecoration(outRect: Rect, position: Int, totalCount: Int) {


    }

}