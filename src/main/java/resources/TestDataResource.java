package resources;

import java.util.ArrayList;

import Places_Pojo_class.Step1_setObjectsforPlaces;

public class TestDataResource {
	
	
	public Step1_setObjectsforPlaces getTestData(String name, String language, String address) {
		
		
		Step1_setObjectsforPlaces sop= new Step1_setObjectsforPlaces();
		sop.setAccuracy(50);
		sop.setAddress(address);
		sop.setLanguage(language);
		sop.setName(name);
		sop.setPhone_number("4135556667");
		sop.setWebsite("http://google.com");
		
		ArrayList <String> al = new ArrayList<String>();
		al.add("shoe park");
		al.add("shop");
		sop.setTypes(al);
		
		Places_Pojo_class.Step3_setLatlong sl= new Places_Pojo_class.Step3_setLatlong();
		sl.setLat(-38.383494);
		sl.setLng(33.427362);
		sop.setLocation(sl);
		
		
		
		return sop;
		
	}


	
	
}
