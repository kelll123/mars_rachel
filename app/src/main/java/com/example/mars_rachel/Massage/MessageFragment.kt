package com.example.mars_rachel.Massage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mars_rachel.Massage.Tutorial.TutorialMessageActivity
import com.example.mars_rachel.R
import com.example.mars_rachel.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1","25"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2","21"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3","22"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4","23"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5","24"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6","26"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7","27"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8","28"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9","29"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10","30")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

        // Aktifkan option menu (Sesuai modul Pertemuan 11 Halaman 5)
        setHasOptionsMenu(true)
    }

    // Inflate menu XML (Sesuai modul Pertemuan 11 Halaman 6)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // Aksi klik menu tutorial (Sesuai modul Pertemuan 11 Halaman 6)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}