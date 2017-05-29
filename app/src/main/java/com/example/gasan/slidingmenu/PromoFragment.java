package com.example.gasan.slidingmenu;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromoFragment extends Fragment {


    public PromoFragment() {
        // Required empty public constructor
    }
    View rootView;
    ProgressDialog prDialog;
    private WebView webPromo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_promo, container, false);
        getActivity().setTitle("Promo");
        webPromo = (WebView) rootView.findViewById(R.id.webaward);
        WebSettings ws1 = webPromo.getSettings();
        ws1.setJavaScriptEnabled(true);
        webPromo.loadUrl("http://green-nitrogen.com/website/info/promo.html");
        webPromo.setWebViewClient(new PromoFragment.LihatAplikasi());

        return rootView;
    }

    private class LihatAplikasi extends WebViewClient
    {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            // TODO: Implement this method
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon)
        {
            // TODO: Implement this method
            super.onPageStarted(view, url, favicon);
            rootView.findViewById(R.id.loading).setVisibility(view.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url)
        {
            // TODO: Implement this method
            super.onPageFinished(view, url);
            rootView.findViewById(R.id.loading).setVisibility(view.GONE);
        }

    }

}
