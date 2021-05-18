package com.smb.smbapplication.ui.login
/**
 * Created by Shijil Kadambath on 03/08/2018
 * for NewAgeSMB
 * Email : shijil@newagesmb.com
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.smb.smbapplication.R
import com.smb.smbapplication.binding.FragmentDataBindingComponent
import com.smb.smbapplication.common.autoCleared
import com.smb.smbapplication.databinding.FragmentRegistrationStepOneBinding
import com.smb.smbapplication.databinding.FragmentRegistrationStepTwoBinding
import com.smb.smbapplication.di.Injectable
import com.smb.smbapplication.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_registration_step_one.*

private const val TAG = "RegistrationStepOneFragment"

/**
 * A simple [Fragment] subclass.
 *
 */
class RegistrationStepOneFragment : BaseFragment() {



    override fun getLayoutId()= R.layout.fragment_registration_step_one


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_submit.setOnClickListener {

            navController().navigate(
                    RegistrationStepOneFragmentDirections.showRegistrationStepTwo( btn_submit.text.toString(),
                            btn_submit.text.toString())
            )
        }
    }

    fun navController() = findNavController()
}
