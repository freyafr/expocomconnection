package com.sitronics.dataprovider;

import java.util.ArrayList;

import android.content.Context;

import com.sitronics.expocomconnection.R;

import com.sitronics.data.Solution;
import com.sitronics.data.Event;
import com.sitronics.data.SolutionGroup;

@SuppressWarnings("serial")
final public class SolutionProvider {
	public static ArrayList<SolutionGroup> getSolutions(final Context context) {
		return new ArrayList<SolutionGroup>() {
			{
				add(new SolutionGroup(
						"Возведение и эксплуатация социальных и спортивных объектов",
						new ArrayList<Solution>() {
							{
								add(new Solution(
										"Мониторинг строительства объектов",
										context.getString(R.string.s1),
										R.drawable.info1));
								add(new Solution(
										"Контроль и анализ проектных затрат",
										context.getString(R.string.s2),
										R.drawable.info2));
								add(new Solution(
										"Инженерная и телекоммуникационная инфраструктура",
										context.getString(R.string.s3),
										R.drawable.info));
								add(new Solution("Управление энергозатратами",
										context.getString(R.string.s4),
										R.drawable.info));
								add(new Solution(
										"Мониторинг грузовой и специальной техники",
										context.getString(R.string.s5),
										R.drawable.info));
							}

						}));
				add(new SolutionGroup(
						"Обеспечение безопасности и координация работ",
						new ArrayList<Solution>() {
							{
								add(new Solution("\"Система  112\"", context
										.getString(R.string.s6),
										R.drawable.info));
								add(new Solution(
										"Биометрический контроль доступа",
										context.getString(R.string.s7),
										R.drawable.info));
								add(new Solution(
										"Пространственное моделирование событий",
										context.getString(R.string.s8),
										R.drawable.info));
								add(new Solution(
										"Управление процессами и персоналом ",
										context.getString(R.string.s9),
										R.drawable.info));
							}

						}));

				add(new SolutionGroup("Сервисы для участников",
						new ArrayList<Solution>() {
							{
								add(new Solution("Ncloud", context
										.getString(R.string.s10),
										R.drawable.info));
								add(new Solution(
										"Универсальная карта участника",
										context.getString(R.string.s11),
										R.drawable.info));
								add(new Solution(
										"Портал общественной безопасности",
										context.getString(R.string.s12),
										R.drawable.info));
								add(new Solution(
										"Система анализа статистических данных",
										context.getString(R.string.s13),
										R.drawable.info));
								add(new Solution(
										"Сервисы облачной видеоаналитики",
										context.getString(R.string.s14),
										R.drawable.info));
								add(new Solution(
										"Удаленный мониторинг автопарка",
										context.getString(R.string.s15),
										R.drawable.info));
							}

						}));
			}
		};
	}
}
