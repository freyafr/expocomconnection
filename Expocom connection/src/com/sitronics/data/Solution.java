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
	
	public String getShortDescription()
	{
		return _shortDescription;
	}
	
	public String getDescription()
	{
		return _longDescription;
	}
	
	public String getContactName()
	{
		return _contactName;
	}
	
	public String getContactEmail()
	{
		return _contactEmail;
	}
}
