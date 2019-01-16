package com.example.jcasas.githubjetpackexample.presentation.information

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jcasas.githubjetpackexample.R
import kotlinx.android.synthetic.main.fragment_info.*

class InformationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            LayoutInflater.from(container?.context).inflate(R.layout.fragment_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        val licenseString = getString(R.string.information_license)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textInfoLicenseBody.text = Html.fromHtml(licenseString, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textInfoLicenseBody.text = Html.fromHtml(licenseString)
        }
    }
}