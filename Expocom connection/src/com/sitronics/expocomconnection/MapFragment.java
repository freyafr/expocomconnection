package com.sitronics.expocomconnection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MapFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.map_fragment, container, false);

		WebView webView = (WebView) result.findViewById(R.id.webview);
		webView.loadUrl("file:///android_res/drawable/map.jpg");
		webView.getSettings().setBuiltInZoomControls(true);
		return result;
	}
}
