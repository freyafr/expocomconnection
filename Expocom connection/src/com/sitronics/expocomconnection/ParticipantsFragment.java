package com.sitronics.expocomconnection;

import android.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;

public final class ParticipantsFragment extends Fragment {
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.participants_fragment,
	        container, false);
	    return view;
	  }
}
