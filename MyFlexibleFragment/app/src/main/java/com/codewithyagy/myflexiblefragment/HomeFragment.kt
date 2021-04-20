package com.codewithyagy.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// Latihan Fragment di Activity
class HomeFragment : Fragment(), View.OnClickListener {


    /* Layout interface didefinisikan dan ditransformasikan dari layout berupa file xml ke dalam objek view
       dengan menggunakan metode inflate()
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /* Metode onViewCreated() yang akan bekerja setelah metode onCreateView()
       Di sini kita bisa gunakan untuk inisialisasi view dan juga mengatur action-nya(set listener)
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCategory: Button =
            view.findViewById(R.id.btn_category) // Pemanggilan findViewById() perlu menambahkan variabel view
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // Latihan Flexible Fragment di Satu Activity

        // Pindah tampilan fragment ke CategoryFragment
        if (v.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()

            // Activity memanfaatkan supportFragmentManager, Fragment menggunakan fragmentManager untuk mendapatkan FragmentManager
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {

                /*
                method replace() menggantikan objek fragment yang sedang tampil saat ini,
                yaitu HomeFragment dengan objek fragment yang baru yaitu CategoryFragment
                 */
                replace(
                    R.id.frame_container,
                    mCategoryFragment,
                    CategoryFragment::class.java.simpleName
                )

                /*
                Kita menggunakan addToBackStack() karena objek fragment yang saat ini diciptakan masuk ke dalam sebuah fragment stack.
                Nantinya ketika kita tekan tombol back, ia akan pop-out keluar dari stack dan menampilkan objek fragment sebelumnya HomeFragment
                 */
                addToBackStack(null)
                commit()
            }
        }
    }

}