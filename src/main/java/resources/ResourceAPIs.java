package resources;

public enum ResourceAPIs {
	
	//enum is a special class consisting of constants and methods.
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"), 
	DeletePlaceAPI("/maps/api/place/delete/json"),
	PutPlaceAPI("/maps/api/place/update/json");

	public String resource;
	//this constructor wont return anything inorder for us to capture in Steps class. In order for this constructor to return the resourceapi
	//we will create method
	ResourceAPIs(String resource) {
		
		this.resource=resource;
		
	}
	
	
	//the resource variable in this method here doesnot have knowledge of above resource, hence we need to create a global variable and give
	// it the knowledge of resource parameter in constructor.
	public String getresourceApi() {
		
		
		return resource;
		
		
	}
	
	



}
