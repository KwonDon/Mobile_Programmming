package kr.ac.hallym.project_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kr.ac.hallym.project_final.databinding.ActivityUrlBinding

class Url_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUrlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        var url_data = intent.getStringExtra("url")
        if (url_data != null) {
            binding.webView.loadUrl(url_data)
        }

    }
}