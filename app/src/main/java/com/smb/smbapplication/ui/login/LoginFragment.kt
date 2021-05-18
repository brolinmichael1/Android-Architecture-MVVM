package com.smb.smbapplication.ui.login

/**
 * Created by Shijil Kadambath on 03/08/2018
 * for NewAgeSMB
 * Email : shijil@newagesmb.com
 */
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.smb.smbapplication.AppExecutors

import com.smb.smbapplication.R
import com.smb.smbapplication.common.autoCleared
import com.smb.smbapplication.data.model.User
import com.smb.smbapplication.databinding.FragmentLoginBinding
import com.smb.smbapplication.ui.BaseDataFragment
import com.smb.smbapplication.ui.BaseFragment
import com.smb.smbapplication.ui.RetryCallback
import com.smb.smbapplication.utils.logger.Log
import javax.inject.Inject

private const val TAG: String = "LoginFragment"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : BaseDataFragment<FragmentLoginBinding>() {


    @Inject
    lateinit var appExecutors: AppExecutors

    lateinit var mViewModel: LoginViewModel

    var adapter by autoCleared<ListAdapter>()


    override fun getLayoutId(): Int {
        return R.layout.fragment_login;
    }

    var list: ArrayList<User>? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewModel = getViewModel(LoginViewModel::class.java)

        list = arrayListOf()

        adapter =  ListAdapter( appExecutors = appExecutors) {

            navController().navigate(
                    LoginFragmentDirections.showRegistration()
            )
        }

        mBinding.listUser.adapter = adapter

        mViewModel.repositories.observe(this, Observer { result ->

            mBinding.searchResource = result

            mBinding.resultCount = result?.data?.data?.size ?: 0

            if (!result?.data?.data.isNullOrEmpty()) {

                list = result?.data?.data as ArrayList<User>;

                adapter.submitList(list)
                adapter.notifyDataSetChanged()
            }
        })

        /*  var list = ArrayList<User>()
          list .add(User("aaaa",1))
          list .add(User("bbbb",1))
          list .add(User("cccc",1))
          list .add(User("dddd",1))
          adapter.submitList(list)*/

        //adapter = rvAdapter

        mBinding.image = "https://cdn.freebiesupply.com/logos/large/2x/android-logo-png-transparent.png"

        mBinding.callback = object : RetryCallback {
            override fun retry() {
                mViewModel.retry()
            }
        }

        mBinding.button.setOnClickListener {

            //Log.e("list", adapter.getItemValue(0).name)
            Log.e("list", list!!.joinToString(","))

        }

        mViewModel.loadData()
    }

    fun navController() = findNavController()
}
