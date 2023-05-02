package woowacourse.movie.view

import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import domain.Seat
import domain.discountPolicy.DisCountPolicies
import domain.seatPolicy.SeatPolicies
import woowacourse.movie.R
import woowacourse.movie.setBackgroundColorId
import woowacourse.movie.model.mapper.SeatMapper
import woowacourse.movie.model.mapper.SeatRankMapper
import woowacourse.movie.model.mapper.SeatRankMapper.toUi
import woowacourse.movie.model.SeatUiModel

class SeatView(val view: TextView, val row: Char, val col: Int, onClick: (SeatView) -> Unit) {
    init {
        view.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f
        )
        view.text = row.toString() + col.toString()
        view.textSize = 22f
        view.gravity = Gravity.CENTER
        view.isSelected = false
        setBackgroundColorId(R.color.white)
        initTextColor()
        view.setOnClickListener { onClick(this) }
    }
    private fun initTextColor() {
        val seat = Seat(SeatUiModel.toNumber(row), col)
        val seatRankViewModel = seat.rank.toUi()
        view.setTextColor(
            ContextCompat.getColor(
                view.context, seatRankViewModel.color
            )
        )
    }

    fun setBackgroundColorId(color: Int) {
        view.setBackgroundColorId(color)
    }
}
