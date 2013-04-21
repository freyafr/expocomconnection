package com.sitronics.dataprovider;

import java.util.ArrayList;

import com.sitronics.data.Solution;
import com.sitronics.data.Event;

@SuppressWarnings("serial")
final public class SolutionProvider
{
	public static ArrayList<Solution> getSolutions()
	{
		return new ArrayList<Solution>(){{
				add(new Solution("3","","","",""));
				add(new Solution("33","","","",""));
				add(new Solution("244","","","",""));
			}};
	}
}
