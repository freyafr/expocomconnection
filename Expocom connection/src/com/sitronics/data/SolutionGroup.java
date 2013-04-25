package com.sitronics.data;

import java.util.ArrayList;

public class SolutionGroup {

	private String _name;

	private ArrayList<Solution> _solutions;

	public SolutionGroup(String name, ArrayList<Solution> solutions) {
		_name = name;
		_solutions = solutions;
	}

	public String getName() {
		return _name;
	}

	public ArrayList<Solution> getSolutions() {
		return _solutions;
	}
}
