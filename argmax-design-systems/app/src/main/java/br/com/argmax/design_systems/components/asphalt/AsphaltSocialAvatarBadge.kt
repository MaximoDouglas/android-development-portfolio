package br.com.argmax.design_systems.components.asphalt

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltSocialAvatarBadgeBinding
import br.com.argmax.design_systems.extentions.setCircularImageByUrlWithBorder

class AsphaltSocialAvatarBadge @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mUrlList: MutableList<String>? = null

    private var mBinding: AsphaltSocialAvatarBadgeBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.asphalt_social_avatar_badge,
            this,
            true
        )

    fun setLabelAndImageUrlList(badgeLabel: String, imageUrls: List<String>): Boolean {
        return if (imageUrls.isEmpty()) {
            false
        } else {
            setupImageViewResources(imageUrls)
            setupLabelText(badgeLabel)

            mBinding?.executePendingBindings()
            return true
        }
    }

    private fun setupImageViewResources(imageUrls: List<String>) {
        val mainImageUrl = imageUrls[0]
        mUrlList         = mutableListOf(mainImageUrl)

        mBinding?.asphaltSocialAvatarBadgeMainImageView?.setCircularImageByUrlWithBorder(mainImageUrl)

        if (imageUrls.size > 1) {
            val secondaryImageVisibility = View.VISIBLE
            val secondaryImageUrl        = imageUrls[1]

            mUrlList?.add(secondaryImageUrl)

            mBinding?.asphaltSocialAvatarBadgeSecondaryImageView?.visibility =
                secondaryImageVisibility

            mBinding?.asphaltSocialAvatarBadgeSecondaryImageView?.setCircularImageByUrlWithBorder(secondaryImageUrl)
        }
    }

    private fun setupLabelText(badgeLabel: String) {
        mBinding?.asphaltSocialAvatarBadgeLabelTextView?.text = badgeLabel
    }

    fun getLabelText(): CharSequence? {
        return mBinding?.asphaltSocialAvatarBadgeLabelTextView?.text
    }

    fun getImageUrlList(): List<String>? {
        return mUrlList;
    }

    fun isMainImageVisible(): Boolean {
        return mBinding?.asphaltSocialAvatarBadgeMainImageView?.visibility == View.VISIBLE
    }

}