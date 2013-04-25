package com.sitronics.expocomconnection;

import com.sitronics.data.Day;
import com.sitronics.data.Event;
import com.sitronics.data.Solution;
import com.sitronics.data.SolutionGroup;
import com.sitronics.dataprovider.ScheduleProvider;
import com.sitronics.dataprovider.SolutionProvider;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.*;

public class SolutionFragment extends ListFragment {

	public void onItemClick(AdapterView<?> p1, View view, int position, int parentPosition, long p4) {
		SolutionGroup solutionGroup = (SolutionGroup) getListAdapter().getItem(parentPosition);
		Solution solution = solutionGroup.getSolutions().get(position);
		Intent descrIntent = new Intent(getActivity(),
				SolutionDetailsFragment.class);
		descrIntent.putExtra("name", solution.getName());
		descrIntent.putExtra("description", solution.getDescription());

		startActivity(descrIntent);
	}

	private ArrayAdapter<SolutionGroup> mAdapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mAdapter = new ArrayAdapter<SolutionGroup>(getActivity(),
				R.layout.solution_group_item,
				SolutionProvider.getSolutions(getActivity())) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				final SolutionGroup group = getItem(position);

				final View solutionView = getActivity().getLayoutInflater()
						.inflate(R.layout.solution_group_item, null);

				final TextView solutionNameView = (TextView) solutionView
						.findViewById(R.id.group_item_title);
				solutionNameView.setText(group.getName());

				final LinearLayout linearLayout = (LinearLayout) solutionView
						.findViewById(R.id.solution_list_items);

				int localPosition = 0;
				for (Solution solution : group.getSolutions()) {
					View solutionItemView = LayoutInflater.from(getContext())
							.inflate(R.layout.solution_item, null);

					final TextView parentCode = (TextView) solutionItemView
							.findViewById(R.id.solution_parent_code);

					parentCode.setText(Integer.valueOf(position).toString());

					final TextView code = (TextView) solutionItemView
							.findViewById(R.id.solution_code);

					code.setText(Integer.valueOf(localPosition).toString());

					final TextView name = (TextView) solutionItemView
							.findViewById(R.id.solution_name);

					name.setText(solution.getName());
					linearLayout.addView(solutionItemView);
					localPosition++;
				}

				return solutionView;
			}
		};

	}

	@Override
	public void onStart() {
		super.onStart();
		setListAdapter(mAdapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		//onItemClick(l, v, position, id);
	}

}
