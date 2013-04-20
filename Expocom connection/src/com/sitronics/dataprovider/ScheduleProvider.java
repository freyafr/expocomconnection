package com.sitronics.dataprovider;

import java.util.ArrayList;

import com.sitronics.data.Day;
import com.sitronics.data.Event;

@SuppressWarnings("serial")
final public class ScheduleProvider {
	public static ArrayList<Day> getSchedule(){
		return new ArrayList<Day>(){{
			add(new Day(){{
				title = "13 ��� - �����������";
				events = new ArrayList<Event>(){{
					add(new Event(){{
						title = "������ ������ ��������";
						start = "10:00";
						end = null;
					}});
					add(new Event(){{
						title = "��� �� ���";
						start = "10:00";
						end = "12:00";
					}});
					add(new Event(){{
						title = "��� �� ��� 1";
						start = "10:00";
						end = "18:00";
					}});
				}};
			}});

			this.add(new Day(){{
				title = "14 ��� - �������";
				events = new ArrayList<Event>(){{
					add(new Event(){{
						title = "��� �� ��� 3";
						start = "10:00";
						end = null;
					}});
					add(new Event(){{
						title = "��� �� ��� 4";
						start = "10:00";
						end = "12:00";
					}});
					add(new Event(){{
						title = "��� �� ��� 5";
						start = "10:00";
						end = "18:00";
					}});
				}};
			}});
		}};
	}
}