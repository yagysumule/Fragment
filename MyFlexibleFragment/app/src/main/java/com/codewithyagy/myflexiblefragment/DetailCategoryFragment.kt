package com.codewithyagy.myflexiblefragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

// Latihan Mengirim Data Antar Fragment
class DetailCategoryFragment : Fragment() {

    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button

    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)

        // Latihan Memanggil Activity dari fragment
        btnProfile = view.findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener {
            /*
            Fungsi activity dipanggil karena menggunakan fragment
            Menggunakan fungsi activity untuk mendapatkan context dari activity tempat fragment ini menempel
            */
            val mIntent = Intent(activity, ProfileActivity::class.java)
            startActivity(mIntent)
        }

        // Latihan Menampilkan sebuah custom dialog
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnShowDialog.setOnClickListener {
            val mOptionDialogFragment = OptionDialogFragment()

            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(
                mFragmentManager,
                OptionDialogFragment::class.java.simpleName
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Latihan Mengirim Data Antar Fragment
        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            // Mengambil data yang dikirimkan melalui obyek bundle pada fragment
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName

            // Mengambil data yang dikirimkan menggunakan metode getter
            tvCategoryDescription.text = description
        }
    }

    // Latihan Menampilkan sebuah custom dialog
    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener =
        object : OptionDialogFragment.OnOptionDialogListener {
            override fun onOptionChosen(text: String?) {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
            }
        }

}