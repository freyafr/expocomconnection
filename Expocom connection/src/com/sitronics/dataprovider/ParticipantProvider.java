package com.sitronics.dataprovider;

import java.util.ArrayList;

import com.sitronics.data.Address;
import com.sitronics.data.Participant;

@SuppressWarnings("serial")
public class ParticipantProvider {
	public static ArrayList<Participant> getParticipants(){
		return new ArrayList<Participant>(){{
			add(new Participant(){{
				name = "������� �����";
				address = new Address();
				description = "�������� ��������, ����� ����� ����� �� ����������";
			}});
			add(new Participant(){{
				name = "����� �����";
				address = new Address();
				description = "�������� ������, ����� ����� ����� �� ����������";
			}});
			add(new Participant(){{
				name = "������� �����";
				address = new Address();
				description = "�������� ������� ������, ����� ����� ����� �� ����������";
			}});
		}};
	}
}