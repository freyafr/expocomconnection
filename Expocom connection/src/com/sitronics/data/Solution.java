package com.sitronics.data;

public class Solution
{
	private String _name;
	private String _shortDescription;
	private String _longDescription;
	private String _contactName;
	private String _contactEmail;

	public Solution(String name,
					String shortDescription,
					String longDescription,
					String contactName,
					String contactEmail)
	{
		_name = name;
		_shortDescription = shortDescription;
		_longDescription = longDescription;
		_contactName = contactName;
		_contactEmail = contactEmail;
	}
	
	public String getName()
	{
		return _name;
	}
}
