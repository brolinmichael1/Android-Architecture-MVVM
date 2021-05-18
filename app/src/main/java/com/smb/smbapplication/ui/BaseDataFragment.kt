package com.smb.smbapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smb.smbapplication.binding.FragmentDataBindingComponent
import com.smb.smbapplication.common.autoCleared
import com.smb.smbapplication.di.Injectable
import javax.inject.Inject

/**
 * Created by Shijil Kadambath on 03/08/2018
 * for bigtime
 * Email : shijilkadambath@gmail.com
 */


/**
 * A generic Fragment   .
 * @param <T> The type of the ViewDataBinding.
*/

abstract class BaseDataFragment< T : ViewDataBinding> : BaseFragment() {


    var mBinding by autoCleared<T>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(),
                container, false, dataBindingComponent)

        return mBinding?.root
    }


}
