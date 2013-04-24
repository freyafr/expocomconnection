package com.sitronics.expocomconnection;

import com.sitronics.data.Day;
import com.sitronics.data.Event;
import com.sitronics.data.Solution;
import com.sitronics.dataprovider.ScheduleProvider;
import com.sitronics.dataprovider.SolutionProvider;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.*;
import android.content.*;



public class SolutionFragment extends ListFragment
{

	public void onItemClick(AdapterView<?> p1, View view, int position, long p4)
	{
		Solution solution = (Solution) getListAdapter().getItem(
			position);
		Intent descrIntent = new Intent(getActivity(), SolutionDetailsFragment.class);
		descrIntent.putExtra("name", solution.getName());
		descrIntent.putExtra("description", solution.getDescription());
		descrIntent.putExtra("contactName", solution.getContactName());
		descrIntent.putExtra("contactEmail", solution.getContactName());
		startActivity(descrIntent);
	}

	private ArrayAdapter<Solution> mAdapter;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		mAdapter = new ArrayAdapter<Solution>(getActivity(),
											  R.layout.solution_item, SolutionProvider.getSolutions(getActivity())) 
		{
			@Override
			public View getView(int position, View convertView, ViewGroup parent) 
			{
				final Solution solution = getItem(position);

				final View solutionView = getActivity().getLayoutInflater().inflate(
					R.layout.solution_item, null);

				final TextView solutionNameView = (TextView) solutionView
					.findViewById(R.id.solution_name);
				solutionNameView.setText(solution.getName());

				final TextView solutionShortDescription = (TextView) solutionView
					.findViewById(R.id.solution_short_descr);

				solutionShortDescription.setText(solution.getShortDescription());

				final TextView idView = (TextView) solutionView
					.findViewById(R.id.solution_code);
				idView.setText(new Integer(position).toString());

				return solutionView;
			}
		};

	}

	@Override
	public void onStart()
	{
		super.onStart();
		setListAdapter(mAdapter);				
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		onItemClick(l,v,position,id);
	}
	
}
