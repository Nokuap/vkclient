package com.hiqo_solutions.vkclient;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hiqo_solutions.vkclient.feed.FeedActivity;
import com.hiqo_solutions.vkclient.utils.Prefs;
import com.orhanobut.hawk.Hawk;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.login_view) WebView loginView;
    private static final String CLIENT_ID = "5011812";
    private static final String REDIRECT_SEGMENT = "blank.html";
    private static final Uri AUTH_URI = new Uri.Builder()
            .scheme("https")
            .authority("oauth.vk.com")
            .path("authorize")
            .appendQueryParameter("client_id", CLIENT_ID)
            .appendQueryParameter("display", "mobile")
            .appendQueryParameter("scope", "offline,friends,photos,audio,video,docs,notes,pages,status,offers,questions,wall,groups,messages,email,notifications,stats")
            .appendQueryParameter("redirect_uri", "https://oauth.vk.com/blank.html")
            .appendQueryParameter("response_type", "token")
            .appendQueryParameter("v", "5.36")
//            .appendQueryParameter("revoke", "1")
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Timber.d(AUTH_URI.toString());
        loginView.loadUrl(AUTH_URI.toString());
        loginView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Uri uri = Uri.parse(url);
                if (REDIRECT_SEGMENT.equals(uri.getLastPathSegment())) {
                    String token = splitQuery(url).get("access_token");
                    Hawk.put(Prefs.TOKEN, token);
                    startActivity(new Intent(LoginActivity.this, FeedActivity.class));
                }
                super.onPageStarted(view, url, favicon);
            }
        });
    }

    public static Map<String, String> splitQuery(String url) {
        Map<String, String> params = new LinkedHashMap<>();
        try {
            String query = new URL(url).getRef();
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                params.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return params;
    }
}
