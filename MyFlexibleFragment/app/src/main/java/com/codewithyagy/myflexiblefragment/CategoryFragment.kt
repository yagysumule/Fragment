package com.codewithyagy.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// Latihan Flexible Fragment di Satu Activity
class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // Latihan Mengirim Data Antar Fragment

        if (v.id == R.id.btn_detail_category) {
            val mDetailCategoryFragment = DetailCategoryFragment()

            // Menggunakan obyek bundle untuk mengirimkan data antar fragment.
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")

            // Menggunakan Setter dan Getter mengirimkan data antar fragment.
            val description = "Kategori ini akan berisi produk-produk lifestyle"

            // Menggunakan obyek bundle untuk mengirimkan data antar fragment.
            // Setelah dibuat obyeknya dan data yang mau dikirimkan apa, kita hanya perlu menambahkan sebaris kode berikut:
            mDetailCategoryFragment.arguments = mBundle

            // Menggunakan Setter dan Getter mengirimkan data antar fragment.
            mDetailCategoryFragment.description = description

            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.frame_container,
                    mDetailCategoryFragment,
                    DetailCategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }

}