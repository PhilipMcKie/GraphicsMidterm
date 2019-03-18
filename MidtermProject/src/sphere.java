import com.jogamp.opengl.GL2;

public class sphere extends Node3D{
	private double radius;
	private int slices;
	private int stacks;
	
	public sphere(double radius, int slices, int stacks) {
		this.radius = radius;
		this.slices = slices;
		this.stacks = stacks;
	}
	
	public void draw(GL2 gl2)
	{
		getTransformRecursive();
		drawSphere(gl2);
		
		
	}
	
	private void drawSphere(GL2 gl2) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be positive.");
        if (slices < 3)
            throw new IllegalArgumentException("Number of slices must be at least 3.");
        if (stacks < 2)
            throw new IllegalArgumentException("Number of stacks must be at least 2.");
        for (int j = 0; j < stacks; j++) {
            double latitude1 = (Math.PI/stacks) * j - Math.PI/2;
            double latitude2 = (Math.PI/stacks) * (j+1) - Math.PI/2;
            double sinLat1 = Math.sin(latitude1);
            double cosLat1 = Math.cos(latitude1);
            double sinLat2 = Math.sin(latitude2);
            double cosLat2 = Math.cos(latitude2);
            gl2.glBegin(GL2.GL_QUAD_STRIP);
            for (int i = 0; i <= slices; i++) {
                double longitude = (2*Math.PI/slices) * i;
                double sinLong = Math.sin(longitude);
                double cosLong = Math.cos(longitude);
                double x1 = cosLong * cosLat1;
                double y1 = sinLong * cosLat1;
                double z1 = sinLat1;
                double x2 = cosLong * cosLat2;
                double y2 = sinLong * cosLat2;
                double z2 = sinLat2;
                gl2.glNormal3d(x2,y2,z2);
                gl2.glVertex3d(radius*x2,radius*y2,radius*z2);
                gl2.glNormal3d(x1,y1,z1);
                gl2.glVertex3d(radius*x1,radius*y1,radius*z1);
            }
            gl2.glEnd();
        }
    }
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public int getSlices()
	{
		return this.slices;
	}
	
	public int getStacks()
	{
		return this.stacks;
	}
	
	public void setRadius(double newRadius)
	{
		this.radius = newRadius;
	}
	
	public void setSlices(int newSlices)
	{
		this.slices = newSlices;
	}
	
	public void setStacks(int newStacks)
	{
		this.stacks = newStacks;
	}
	

	@Override
	public void getTransformRecursive() {
		// TODO Auto-generated method stub
		
	}

}
