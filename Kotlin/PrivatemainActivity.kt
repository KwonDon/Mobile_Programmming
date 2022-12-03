package kr.ac.hallym.project_final

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import androidx.viewpager2.widget.ViewPager2
import kr.ac.hallym.project_final.databinding.ActivityPrivatemainBinding
import kr.ac.hallym.project_final.databinding.ItemMainBinding



class PrivatemainActivity : AppCompatActivity() {
    lateinit var viewpager2 : ViewPager2
    lateinit var binding :ActivityPrivatemainBinding
    class MyFragmentPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
        val fragment : List<Fragment>
        var position = 0
        init {
            fragment = listOf(Profilefragment() , Projectfragment() , GradesFragment())
        }

        override fun getItemCount(): Int = fragment.size
        override fun createFragment(position: Int): Fragment {
            return fragment[position]
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPrivatemainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)

        binding.backHome.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }



        viewpager2 = binding.viewpager
        var adapter = MyFragmentPagerAdapter(this)
        viewpager2.adapter = adapter



        binding.privateMainDrawerView.setNavigationItemSelectedListener {
            if(it.title.equals("GitHub")){
                val intent = Intent(this , GitActivity::class.java)
                startActivity(intent)
                finish()
            }else if(it.title.equals("Profile")){
                adapter = MyFragmentPagerAdapter(this)
                viewpager2.adapter = adapter
                viewpager2.currentItem = 0
            }else if(it.title.equals("Project")){
                adapter = MyFragmentPagerAdapter(this)
                viewpager2.adapter = adapter
                viewpager2.currentItem = 1
            }
            else if(it.title.equals("Grade")){
                adapter = MyFragmentPagerAdapter(this)
                viewpager2.adapter = adapter
                viewpager2.currentItem = 2
            }
            true
        }

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                Log.d("kwon" , "change $position")
                if(position in 0..1){
                    binding.toolbar.visibility = View.VISIBLE
                }else{
                    binding.toolbar.visibility = View.GONE
                }

                super.onPageSelected(position)
            }
        })
    }
}
