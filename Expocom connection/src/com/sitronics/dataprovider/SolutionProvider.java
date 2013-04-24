package com.sitronics.dataprovider;

import java.util.ArrayList;


import android.content.Context;

import com.sitronics.expocomconnection.R;

import com.sitronics.data.Solution;
import com.sitronics.data.Event;

@SuppressWarnings("serial")
final public class SolutionProvider
{
	public static ArrayList<Solution> getSolutions(final Context context)
	{
		return new ArrayList<Solution>(){{
				add(new Solution("Система анализа больших объемов данных Big Data","Информационно-аналитическая платформа"+
" решает задачи эффективного хранения"+
" и обработки неограниченных объёмов"+
" неструктурированных или слабосвязанных"+
" данных. Демонстрация работы через"+
" пользовательский интерфейс BI-приложения от Qlickview.",context.getString(R.string.s1),"Красилов Дмитрий,\n руководитель центра решений"+
" систем управления данными «Энвижн Груп»","DKrasilov@nvg.ru"));
				add(new Solution("Универсальная карта участника","Решение представляет собой семейство продуктов, обеспечивающих тарификацию различных видов услуг и биллинг, управление услугами абонентов бонусными кампаниями и т.д. Решение включает в себя более 20 систем с широчайшей функциональностью. Например, интегрировать на единой карте болельщика различные услуги: оплата транспортных расходов, входных билетов на домашние матчи, скидки и другие привилегии для держателей карты. Решение также может быть использовано в телекоммуникационной отрасли, ТЭК, госсекторе, на транспорте и т.д.","","",""));
				add(new Solution("244","","3424 dsfsdfdsf\ndfdsfsdf","cfgdg",""));
			}};
	}
}
