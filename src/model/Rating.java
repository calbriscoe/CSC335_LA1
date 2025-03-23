package model;

public enum Rating {
	None, One, Two, Three, Four, Five;
	
	
	public static Rating setRating(int rate) {
		if (rate < 1) {
			rate = 0;
		}
		if (rate > 5) {
			rate = 5;
		}
		
		if (rate == 1) {
			return One;
		} else if (rate == 2) {
			return Two;
		} else if (rate == 3) {
			return Three;
		} else if (rate == 4) {
			return Four;
		} else if (rate == 5) {
			return Five;
		} else {
			return None;
		}
	}
	
	public int toIntValue() { 
	    switch (this) { 
	      case One: return 1; 
	      case Two: return 2; 
	      case Three: return 3; 
	      case Four: return 4; 
	      case Five: return 5;
	      case None: return 0;
	      default: return 0; 
	    } 
	  }
}