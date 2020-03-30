package week1.day1;

public class Android {
	
	long mobileNumber = 7010256089l;
	boolean oldVersionStatus = true;
	String os ="android Nougat";
	int version =10;
	float lastUpdateVersion= 10.03f;
	
	
	public static void main(String[] args) {
		
		Android ref = new Android();
		
		String osName = ref.os;
		int VersionNumber = ref.version;
		float latestUpdateVersion = ref.lastUpdateVersion;
		boolean currentStatus = ref.oldVersionStatus;
		long mnumber = ref.mobileNumber;
		
		System.out.println("The latest release is " +osName);
		System.out.println("latest version number is "+VersionNumber);
		System.out.println("Latest update version "+latestUpdateVersion);
		System.out.println("Status of older version release "+currentStatus);
		System.out.println("mobile number used on latest version " +mnumber);
	}

}
