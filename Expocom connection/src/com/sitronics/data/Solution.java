package com.sitronics.data;

public class Solution
{
	private String _name;	
	private String _longDescription;

	public Solution(String name,					
					String longDescription)
	{
		_name = name;		
		_longDescription = longDescription;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getDescription()
	{
		return _longDescription;
	}
}
