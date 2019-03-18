import com.jogamp.opengl.GL2;

public class Torus extends Node3D {
	private double outerRadius;
	private double innerRadius;
	private int slices;
	private int rings;
	
	public Torus(double outerRadius, double innerRadius, int slices, int rings)
	{
		this.outerRadius = outerRadius;
		this.innerRadius = innerRadius;
		this.slices = slices;
		this.rings = rings;
	}
	
	public double getOuterRadius() {
		return outerRadius;
	}

	public void setOuterRadius(double outerRadius) {
		this.outerRadius = outerRadius;
	}

	public double getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(double innerRadius) {
		this.innerRadius = innerRadius;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	public int getRings() {
		return rings;
	}

	public void setRings(int rings) {
		this.rings = rings;
	}

	public void draw(GL2 gl2) {
		getTransformRecursive();
		drawTorus(gl2);
	}
	
	private void drawTorus(GL2 gl2) {
        if (outerRadius == innerRadius)
            throw new IllegalArgumentException("Outer and inner radii can't be the same.");
        if (outerRadius < innerRadius) {
            double temp = outerRadius;
            outerRadius = innerRadius;
            innerRadius = temp;
        }
        if (innerRadius < 0)
            throw new IllegalArgumentException("Radius can't be negative.");
        if (slices < 3)
            throw new IllegalArgumentException("Number of slices must be 3 or more.");
        if (rings < 3)
            throw new IllegalArgumentException("Number of rings must be 3 or more.");
        double centerRadius = (innerRadius + outerRadius) / 2;
        double tubeRadius = outerRadius - centerRadius;
        for (int i = 0; i < slices; i++) {
            double s1 = 1.0/slices * i;
            double s2 = 1.0/slices * (i+1);
            double centerCos1 = Math.cos(2*Math.PI*s1);
            double centerSin1 = Math.sin(2*Math.PI*s1);
            double centerCos2 = Math.cos(2*Math.PI*s2);
            double centerSin2 = Math.sin(2*Math.PI*s2);
            gl2.glBegin(GL2.GL_QUAD_STRIP);
            for (int j = 0; j <= rings; j++) {
                double t = 1.0/rings * j;
                double cos = Math.cos(2*Math.PI*t - Math.PI);
                double sin = Math.sin(2*Math.PI*t - Math.PI);
                double x1 = centerCos1*(centerRadius + tubeRadius*cos);
                double y1 = centerSin1*(centerRadius + tubeRadius*cos);
                double z1 = sin*tubeRadius;
                gl2.glNormal3d(centerCos1*cos,centerSin1*cos,sin);
                gl2.glVertex3d(x1,y1,z1);
                double x2 = centerCos2*(centerRadius + tubeRadius*cos);
                double y2 = centerSin2*(centerRadius + tubeRadius*cos);
                double z2 = sin*tubeRadius;
                gl2.glNormal3d(centerCos2*cos,centerSin2*cos,sin);
                gl2.glVertex3d(x2,y2,z2);
            }
            gl2.glEnd();
        }
    }
	public void getTransformRecursive() {
		// TODO Auto-generated method stub
		
	}

}
