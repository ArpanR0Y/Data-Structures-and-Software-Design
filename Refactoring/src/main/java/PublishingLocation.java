public class PublishingLocation {
	private final String city;
	private final String state;
	private final String postCode;
	
	public PublishingLocation(String city, String state, String postCode) {
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getPostCode() {
		return postCode;
	}
}