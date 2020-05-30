package all;

class Socket {

	int volt = 250;

	int getVolt() {
		return volt;
	}
}

class LaptopAdapter extends Socket {

	LaptopCharger charger;

	public LaptopAdapter(LaptopCharger charger) {
		this.charger = charger;
	}

	@Override
	int getVolt() {
		return charger.convert(super.getVolt());
	}

}

class MobileAdapter extends Socket {
	MobileCharger charger;

	public MobileAdapter(MobileCharger charger) {
		this.charger = charger;
	}

	@Override
	int getVolt() {
		return charger.convert(super.getVolt());
	}
}

class LaptopCharger {
	int convert(int volt) {
		return volt / 12;
	}
}

class MobileCharger {
	int convert(int volt) {
		return volt / 50;
	}
}

public class MyAdapter {
	
	public static void main(String[] args) {
		LaptopAdapter la = new LaptopAdapter(new LaptopCharger());
		System.out.println(la.getVolt());
		
		MobileAdapter ma = new MobileAdapter(new MobileCharger());
		System.out.println(ma.getVolt());
	}
}
