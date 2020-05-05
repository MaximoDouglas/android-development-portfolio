package br.com.argmax.design_systems.app.modules.selectDesignSystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.SelectDesignSystemFragmentBinding

class SelectDesignSystemFragment : Fragment() {

    private var mBinding: SelectDesignSystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_design_system_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        mBinding?.selectDesignSystemAsphaltButton?.setOnClickListener {
            findNavController().navigate(
                SelectDesignSystemFragmentDirections.actionSelectDesignSystemFragmentToAsphaltDesignSystemFragment()
            )
        }
    }


}
