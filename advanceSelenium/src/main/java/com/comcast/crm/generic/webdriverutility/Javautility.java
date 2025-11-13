package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
	public int getRandomNumbers() {
		Random random=new Random();
		return random.nextInt(5000);
		
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateobj);
			
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sim.format(cal.getTime());
		
		
	}

}
