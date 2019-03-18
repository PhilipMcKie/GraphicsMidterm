import com.jogamp.opengl.GL2;

public class Cube extends Node3D{

	@Override
	public void draw(GL2 gl2) {
		getTransformRecursive();
		gl2.glBegin(GL2.GL_POLYGON);
		gl2.glNormal3f(0, 0, 1);
		//gl2.
	}

	private void drawSquare(GL2 gl2) {
		gl2.glBegin(GL2.GL_POLYGON);
		gl2.glNormal3f(0, 0, 1);
		//gl2.getBoundBuffer(arg0);
	}
	@Override
	public void getTransformRecursive() {
		// TODO Auto-generated method stub
		
	}

}
