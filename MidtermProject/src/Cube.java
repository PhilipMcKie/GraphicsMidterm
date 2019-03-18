import com.jogamp.opengl.GL2;

public class Cube extends Node3D{
	private int side = 1;
	
	public Cube() {
		side = 1;
	}
	
	public Cube(int side) {
		this.side = side;
	}
	
	@Override
	public void draw(GL2 gl2) {
		
        gl2.glPushMatrix();
        gl2.glRotatef(-90,-1,0,0);  // This puts the textures in the orientation I want.
        gl2.glPushMatrix();
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);  // Each side of the cube is a transformed square.
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotatef(90,0,1,0);
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotatef(180,0,1,0);
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotatef(270,0,1,0);
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotatef(90,-1,0,0);
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotatef(-90,-1,0,0);
        gl2.glTranslated(0,0,side/2);
        drawSquare(gl2);
        gl2.glPopMatrix();
        gl2.glPopMatrix();
    } // end cube
	

	private void drawSquare(GL2 gl2) {
        double radius = side/2;
        gl2.glBegin(GL2.GL_POLYGON);
        gl2.glNormal3f(0,0,1);
        
        gl2.glVertex2d(-radius,-radius);
        
        gl2.glVertex2d(radius,-radius);
        
        gl2.glVertex2d(radius,radius);
        
        gl2.glVertex2d(-radius,radius);
        gl2.glEnd();
	}
	@Override
	public void getTransformRecursive() {
		// TODO Auto-generated method stub
		
	}

}
