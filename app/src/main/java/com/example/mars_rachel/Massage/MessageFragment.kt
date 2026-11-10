package com.example.mars_rachel.Massage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mars_rachel.R
import com.example.mars_rachel.databinding.FragmentHomeBinding
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
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}