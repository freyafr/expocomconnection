package com.sitronics.dataprovider;

import java.util.ArrayList;

import com.sitronics.data.Address;
import com.sitronics.data.Participant;

@SuppressWarnings("serial")
public class ParticipantProvider {
	public static ArrayList<Participant> getParticipants(){
		return new ArrayList<Participant>(){{
			add(new Participant(){{
				name = "Вестник связи";
				address = new Address();
				description = "Описание вестника, здесь будет какая та информация";
			}});
			add(new Participant(){{
				name = "Синий вагон";
				address = new Address();
				description = "Описание вагона, здесь будет какая та информация";
			}});
			add(new Participant(){{
				name = "Красный вагон";
				address = new Address();
				description = "Описание другого вагона, здесь будет какая та информация";
			}});
		}};
	}
}
