package kr.ac.hallym.project_final

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.Main
import kr.ac.hallym.project_final.databinding.FragmentProfilefragmentBinding
import kr.ac.hallym.project_final.databinding.FragmentProjectfragmentBinding
import kr.ac.hallym.project_final.databinding.ItemMainBinding


class Projectfragment : Fragment() {
    lateinit var binding : FragmentProjectfragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var title = mutableListOf<String>()
        var details = mutableListOf<String>()
        var url_ = mutableListOf<String>()

        title.add("RSSI 값을 이용한 실내 측위")
        details.add("Deep Learning 모델을 이용한\nSmoothed RSSI 기반 거리추정")
        url_.add("https://github.com/KwonDon/Deep-Learning-Based-RSSI-Estimate-Distance")

        title.add("Embedded System")
        details.add("PIR 센서를 이용한 동작 감지기")
        url_.add("https://github.com/KwonDon/Embedded_CoAp_project")

        title.add("Mobile programming")
        details.add("이력서 어플리케이션 만들기")
        url_.add("https://github.com/KwonDon/Mobile_Programmming")

        title.add("전자파 논문 Crawling")
        details.add("Abstract 분류 후 원하는 논문 크롤링")
        url_.add("https://github.com/KwonDon/Crawling_BaseCode")

        title.add("BLE Beacon을 이용한 모니터링 시스템")
        details.add("Beacon의 RSSI 신호 감지 가반 북카페 모니터링 시스템")
        url_.add("https://34.125.32.237:8000")

        title.add("Wi-Fi CSI 신호 기반 거리 추정")
        details.add("AP와 CSI Receiver 구현 완료\n" +
                "패킷 분석후 sub carrier 추출 후 딥러닝 학습 예정")
        url_.add("https://github.com/KwonDon/Deep-Learning-Based-RSSI-Estimate-Distance")

        title.add("Computer Netwrok Project")
        details.add("소켓통신을 이용하여 비동기 다중 체팅방 구현")
        url_.add("https://github.com/KwonDon/Deep-Learning-Based-RSSI-Estimate-Distance")

        title.add("Linux Project")
        details.add("소켓통신을 이용하여 원카드 게임 구현")
        url_.add("https://github.com/KwonDon/Deep-Learning-Based-RSSI-Estimate-Distance")


        binding = FragmentProjectfragmentBinding.inflate(inflater,container,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = MyAdapter(title,details,url_)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext() , LinearLayoutManager.VERTICAL)
        )

        return binding.root
    }


}
class MyViewHolder(val binding : ItemMainBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val title : MutableList<String> , val detail : MutableList<String>,val url_ : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    = MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.title.text = title[position]
        binding.detail.text = detail[position]
        binding.urlPath.text = url_[position]

        binding.itemRoot.setOnClickListener {
            val intent = Intent(holder.itemView?.context , Url_Activity::class.java)
            intent.putExtra("url" , url_[position])
            ContextCompat.startActivity(holder.itemView.context, intent , null)
        }
    }

    override fun getItemCount(): Int {
        return title.size
    }

}