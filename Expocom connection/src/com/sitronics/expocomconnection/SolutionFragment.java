package com.sitronics.expocomconnection;

import java.util.ArrayList;

import com.sitronics.data.Solution;
import com.sitronics.data.SolutionGroup;
import com.sitronics.dataprovider.SolutionProvider;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.*;

public class SolutionFragment extends Fragment implements
		View.OnClickListener {

	public void onItemClick(AdapterView<?> p1, View view, int position,
			int parentPosition, long p4) {
		SolutionGroup solutionGroup = mAdapter.get(parentPosition);
		Solution solution = solutionGroup.getSolutions().get(position);
		Intent descrIntent = new Intent(getActivity(),
				SolutionDetailsFragment.class);
		descrIntent.putExtra("name", solution.getName());
		descrIntent.putExtra("description", solution.getDescription());
		descrIntent.putExtra("image", solution.getImage());

		startActivity(descrIntent);
	}

	private ArrayList<SolutionGroup> mAdapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.solution_fragment, container,
				false);
		LinearLayout layout = (LinearLayout) view
				.findViewById(R.id.linearLayoutSolutions);
		int position = 0;
		mAdapter = SolutionProvider.getSolutions(getActivity());
		for (SolutionGroup group : mAdapter) {
			final View solutionView = inflater.inflate(
					R.layout.solution_group_item, null);

			final TextView solutionNameView = (TextView) solutionView
					.findViewById(R.id.group_item_title);
			solutionNameView.setText(group.getName());

			final TextView solutionGroupCode = (TextView) solutionView
					.findViewById(R.id.solution_parent_code);
			solutionGroupCode.setText(Integer.valueOf(position).toString());
			final LinearLayout listView = (LinearLayout) solutionView.findViewById(R.id.solution_list_items);			
			
			int lPosition = 0;
			for (Solution solution : group.getSolutions())
			{
				View solutionItemView = inflater.inflate(R.layout.solution_item, null);					

				final TextView code = (TextView) solutionItemView
						.findViewById(R.id.solution_code);

				code.setText(Integer.valueOf(lPosition).toString());

				final TextView name = (TextView) solutionItemView
						.findViewById(R.id.solution_name);

				name.setText(solution.getName());
				
				listView.addView(solutionItemView);
				
				lPosition++;
				
				solutionItemView.setOnClickListener(this);
			}
			

			layout.addView(solutionView);
			position++;
		}
		return view;
	}

	@Override
	public void onClick(View view) {
		
		TextView parentCode = (TextView) ((View) view.getParent().getParent()).findViewById(R.id.solution_parent_code);
		TextView code = (TextView) view.findViewById(R.id.solution_code);
		int position = Integer.parseInt(code.getText().toString());
		int parentPosition = Integer.parseInt(parentCode.getText().toString());
		
		onItemClick(null,view, position,parentPosition, 0);		
	}

}
