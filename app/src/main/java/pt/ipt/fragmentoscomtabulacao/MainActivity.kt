package pt.ipt.fragmentoscomtabulacao

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    //vars auxiliares
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var myViewPageAdapter: MyViewPageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        tabLayout=findViewById(R.id.tab_layout)
        viewPager2=findViewById(R.id.view_pager_2)

        // inicializar o ViewPagerAdapter e atribuí-lo
        // à ViewPager
        myViewPageAdapter= MyViewPageAdapter( this)
        viewPager2.adapter=myViewPageAdapter

        // adicionar ação ao tabulador, quando clica no tabulador
        //
        tabLayout.addOnTabSelectedListener(object: OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab){
                viewPager2.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        //quando faz um movimento de deslizar sobre a zona do ViewPager2
        //tranimistir a ação ao tab
        viewPager2.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }
}