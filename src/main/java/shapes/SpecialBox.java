package shapes;

public class SpecialBox extends Box {

	public SpecialBox() {
		super(0,1,1,0);
	}
	
	@Override
	public Box boundingBox() {
		return new SpecialBox();
	}

}
