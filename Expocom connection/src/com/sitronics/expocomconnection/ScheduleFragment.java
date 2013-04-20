package com.sitronics.expocomconnection;

import java.util.ArrayList;

import com.sitronics.data.Day;
import com.sitronics.data.Event;
import com.sitronics.dataprovider.ScheduleProvider;

import android.graphics.Paint;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.os.*;
import android.support.v4.app.*;

public class ScheduleFragment extends ListFragment {
	private ArrayAdapter<Day> mAdapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mAdapter = new ArrayAdapter<Day>(getActivity(),
				R.layout.schedule_list_item, ScheduleProvider.getSchedule()) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				final Day day = getItem(position);
				final View dayView = getActivity().getLayoutInflater().inflate(
						R.layout.schedule_list_item, null);

				final TextView scheduleTitleTextView = (TextView) dayView
						.findViewById(R.id.schedule_list_item_title);
				scheduleTitleTextView.setText(day.title);
				
				final LinearLayout linearLayout = (LinearLayout ) dayView
						.findViewById(R.id.schedule_list_item_events);

				for(Event event : day.events){
					View eventView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, null);
					final TextView date = (TextView) eventView
							.findViewById(R.id.event_date);
					final TextView title = (TextView) eventView
							.findViewById(R.id.event_title);

					date.setText(event.end == null ? event.start
							: getString(R.string.event_date_format,
									event.start, event.end));
					title.setText(event.title);
					linearLayout.addView(eventView);
					
				}

				return dayView;
			}
		};
	}

	@Override
	public void onStart() {
		super.onStart();
		setListAdapter(mAdapter);
	}
}
