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
		AdapterView.OnItemClickListener {

	public void onItemClick(AdapterView<?> p1, View view, int position,
			int parentPosition, long p4) {
		SolutionGroup solutionGroup = mAdapter.get(parentPosition);
		Solution solution = solutionGroup.getSolutions().get(position);
		Intent descrIntent = new Intent(getActivity(),
				SolutionDetailsFragment.class);
		descrIntent.putExtra("name", solution.getName());
		descrIntent.putExtra("description", solution.getDescription());

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
			final ListView listView = (ListView) solutionView

			.findViewById(R.id.solution_list_items);
			listView.setOnItemClickListener(this);

			listView.setAdapter(new ArrayAdapter<Solution>(getActivity(),
					R.layout.solution_item, group.getSolutions())

			{
				@Override
				public View getView(int lPosition, View convertView,
						ViewGroup parent) {
					final Solution solution = getItem(lPosition);

					View solutionItemView = LayoutInflater.from(getContext())
							.inflate(R.layout.solution_item, null);					

					final TextView code = (TextView) solutionItemView
							.findViewById(R.id.solution_code);

					code.setText(Integer.valueOf(lPosition).toString());

					final TextView name = (TextView) solutionItemView
							.findViewById(R.id.solution_name);

					name.setText(solution.getName());
					return solutionItemView;
				}
			});

			layout.addView(solutionView);
			position++;
		}
		return view;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * mAdapter = new ArrayAdapter<SolutionGroup>(getActivity(),
		 * R.layout.solution_group_item,
		 * SolutionProvider.getSolutions(getActivity())) {
		 * 
		 * @Override public View getView(int position, View convertView,
		 * ViewGroup parent) { final SolutionGroup group = getItem(position);
		 * 
		 * final View solutionView = getActivity().getLayoutInflater()
		 * .inflate(R.layout.solution_group_item, null);
		 * 
		 * final TextView solutionNameView = (TextView) solutionView
		 * .findViewById(R.id.group_item_title);
		 * solutionNameView.setText(group.getName());
		 * 
		 * final ListView linearLayout = (ListView) solutionView
		 * .findViewById(R.id.solution_list_items);
		 * 
		 * 
		 * linearLayout.setAdapter(new ArrayAdapter<Solution>(getActivity(),
		 * R.layout.solution_item, group.getSolutions())
		 * 
		 * {
		 * 
		 * @Override public View getView(int lPosition, View convertView,
		 * ViewGroup parent) { final Solution solution = getItem(lPosition);
		 * 
		 * View solutionItemView = LayoutInflater.from(getContext())
		 * .inflate(R.layout.solution_item, null);
		 * 
		 * final TextView parentCode = (TextView) solutionItemView
		 * .findViewById(R.id.solution_parent_code);
		 * 
		 * // parentCode.setText(Integer.valueOf(position).toString());
		 * 
		 * final TextView code = (TextView) solutionItemView
		 * .findViewById(R.id.solution_code);
		 * 
		 * code.setText(Integer.valueOf(lPosition).toString());
		 * 
		 * final TextView name = (TextView) solutionItemView
		 * .findViewById(R.id.solution_name);
		 * 
		 * name.setText(solution.getName()); return solutionItemView; } });
		 * 
		 * return solutionView; } };
		 */
	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		TextView parentCode = (TextView) ((View) v.getParent().getParent()
				.getParent().getParent())
				.findViewById(R.id.solution_parent_code);
		int parentPosition = Integer.parseInt(parentCode.getText().toString());
		onItemClick(l, v, position, parentPosition, id);
	}

}
