import com.jogamp.opengl.GL2;

public class Cone extends Node3D{
	private double radius;
	private double height;
	private int slices;
	private int stacks;
	private int rings;
	
	public Cone(double radius, double height,int slices, int stacks, int rings)
	{
		this.radius = radius;
		this.height = height;
		this.slices = slices;
		this.stacks = stacks;
		this.rings = rings;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	public int getStacks() {
		return stacks;
	}

	public void setStacks(int stacks) {
		this.stacks = stacks;
	}

	public int getRings() {
		return rings;
	}

	public void setRings(int rings) {
		this.rings = rings;
	}
	
	public void draw(GL2 gl2)
	{
		getTransformRecursive();
		drawCone(gl2);
	}

	private void drawCone(GL2 gl2) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be positive.");
        if (height <= 0)
            throw new IllegalArgumentException("Height must be positive.");
        if (slices < 3)
            throw new IllegalArgumentException("Number of slices must be at least 3.");
        if (stacks < 2)
            throw new IllegalArgumentException("Number of stacks must be at least 2.");
        for (int j = 0; j < stacks; j++) {
            double z1 = (height/stacks) * j;
            double z2 = (height/stacks) * (j+1);
            gl2.glBegin(GL2.GL_QUAD_STRIP);
            for (int i = 0; i <= slices; i++) {
                double longitude = (2*Math.PI/slices) * i;
                double sinLong = Math.sin(longitude);
                double cosLong = Math.cos(longitude);
                double x = cosLong;
                double y = sinLong;
                double nz = radius/height;
                double normLength = Math.sqrt(x*x+y*y+nz*nz);
                gl2.glNormal3d(x/normLength,y/normLength,nz/normLength);
                gl2.glVertex3d((height-z2)/height*radius*x,(height-z2)/height*radius*y,z2);
                gl2.glVertex3d((height-z1)/height*radius*x,(height-z1)/height*radius*y,z1);
            }
            gl2.glEnd();
        }
        if (rings > 0) {
            gl2.glNormal3d(0,0,-1);
            for (int j = 0; j < rings; j++) {
                double d1 = (1.0/rings) * j;
                double d2 = (1.0/rings) * (j+1);
                gl2.glBegin(GL2.GL_QUAD_STRIP);
                for (int i = 0; i <= slices; i++) {
                    double angle = (2*Math.PI/slices) * i;
                    double sin = Math.sin(angle);
                    double cos = Math.cos(angle);
                    gl2.glVertex3d(radius*cos*d2,radius*sin*d2,0);
                    gl2.glVertex3d(radius*cos*d1,radius*sin*d1,0);
                }
                gl2.glEnd();
            }
        }
    }
	
	public void getTransformRecursive() {
		// TODO Auto-generated method stub
		
	}
}
