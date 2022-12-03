package kr.ac.hallym.project_final

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kr.ac.hallym.project_final.databinding.ActivityPrivatemainBinding
import kr.ac.hallym.project_final.databinding.FragmentGradesBinding

class GradesFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentGradesBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.first1.setOnClickListener {
            if(binding.first1Detail.visibility == 8){
                binding.first1Detail.visibility = View.VISIBLE
            }else if(binding.first1Detail.visibility == 0){
                binding.first1Detail.visibility = View.GONE
            }
        }
        binding.first2.setOnClickListener {
            if(binding.first2Detail.visibility == 8){
                binding.first2Detail.visibility = View.VISIBLE
            }else if(binding.first2Detail.visibility == 0){
                binding.first2Detail.visibility = View.GONE
            }
        }
        binding.second1.setOnClickListener {
            if(binding.second1Detail.visibility == 8){
                binding.second1Detail.visibility = View.VISIBLE
            }else if(binding.second1Detail.visibility == 0){
                binding.second1Detail.visibility = View.GONE
            }
        }
        binding.second2.setOnClickListener {
            if(binding.second2Detail.visibility == 8){
                binding.second2Detail.visibility = View.VISIBLE
            }else if(binding.second2Detail.visibility == 0){
                binding.second2Detail.visibility = View.GONE
            }
        }
        binding.third1.setOnClickListener {
            if(binding.third1Detail.visibility == 8){
                binding.third1Detail.visibility = View.VISIBLE
            }else if(binding.third1Detail.visibility == 0){
                binding.third1Detail.visibility = View.GONE
            }
        }
        binding.third2.setOnClickListener {
            if(binding.third2Detail.visibility == 8){
                binding.third2Detail.visibility = View.VISIBLE
            }else if(binding.third2Detail.visibility == 0){
                binding.third2Detail.visibility = View.GONE
            }
        }



        return binding.root
        //return inflater.inflate(R.layout.fragment_grades, container, false)

    }

}