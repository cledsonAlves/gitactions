package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val url = "http://www.thiengo.com.br/doc/projects/integrando-webview-do-android-com-javascript-web/index.php?"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wv = findViewById<View>(R.id.webView) as WebView

        val ws = wv.settings
        ws.javaScriptEnabled = true

        wv.addJavascriptInterface(this, "ExemploWebView")

        wv.loadUrl(url + "apelido=Calopsita")
    }

    @JavascriptInterface
    fun getForm(nome: String, email: String, senha: String) {
        Log.i("Script", "Nome: $nome")
        Log.i("Script", "Email: $email")
        Log.i("Script", "Senha: $senha")
    }
}