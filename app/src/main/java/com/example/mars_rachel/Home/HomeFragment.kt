package com.example.mars_rachel.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.mars_rachel.AuthActivity
import com.example.mars_rachel.Home.pertemuan_10.TenthActivity
import com.example.mars_rachel.Home.pertemuan_11.ElevenActivity
import com.example.mars_rachel.Home.pertemuan_5.FifthActivity
import com.example.mars_rachel.Home.pertemuan_6.SixthActivity
import com.example.mars_rachel.databinding.FragmentHomeBinding
import com.example.mars_rachel.pertemuan_41.FourthActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Action Klik Tombol Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java).apply {
                putExtra("name", "Politeknik Caltex Rumbai")
                putExtra("From", "Rumbai")
                putExtra("age", 25)
            }
            startActivity(intent)
        }

        // Action Klik Tombol Pertemuan 5
        binding.btnTofifthifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // Action Klik Tombol Pertemuan 6
        binding.btnToSixth.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }

        // Action Klik Tombol Pertemuan 10
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToEleven.setOnClickListener {
            val intent = Intent(requireContext(), ElevenActivity::class.java)
            startActivity(intent)
        }

        // Action Klik Tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    // Hapus data session login di SharedPreferences
                    val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    // Kembali ke halaman AuthActivity (Login)
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}