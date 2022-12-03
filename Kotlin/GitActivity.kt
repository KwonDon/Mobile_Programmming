package kr.ac.hallym.project_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kr.ac.hallym.project_final.databinding.ActivityGitBinding

class GitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_git)
        val binding = ActivityGitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        binding.webView.loadUrl("www.github.com/KwonDon")

    }
    override fun onBackPressed() {
        val intent = Intent(this , PrivatemainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }
}