import com.jogamp.opengl.*;
import java.util.*;

public abstract class Node3D {
	private Transform transform;
	public Node3D parent;
	public ArrayList<Node3D> children;
	protected GL2 gl2;
	
	
	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public Node3D getParent() {
		return parent;
	}

	public void setParent(Node3D parent) {
		this.parent = parent;
	}

	public GL2 getGl2() {
		return gl2;
	}

	public void setGl2(GL2 gl2) {
		this.gl2 = gl2;
	}

	public ArrayList<Node3D> getChildren() {
		return children;
	}

	public Node3D() {
		transform = new Transform();
		parent = null;
		children = new ArrayList<Node3D>();
		gl2 = null;

	}

	public Node3D(Node3D parent, GL2 gl2) {
		children = new ArrayList<Node3D>();
		transform = new Transform();
		this.gl2 = gl2;
		this.parent = parent;

	}

	public Node3D(Node3D parent, Node3D[] children) {
		this.parent = parent;
		this.children = new ArrayList<Node3D>(Arrays.asList(children));
	}

	public void addChildNode(Node3D child) {
		children.add(child);
	}

	public abstract void draw(GL2 gl2);

	public abstract void getTransformRecursive();

	class Transform {

		float[] matrix = new float[16];

		public Transform() {
			gl2 = null;
		}

		public Transform(GL2 gl2) {

		}

		public void translate(int x, int y, int z) {
			float[] matrix = new float[16];
			gl2.glGetFloatv(GL2.GL_MODELVIEW_MATRIX, matrix, 0);
		}

		public void rotate(float degrees, int x, int y, int z) {
			// TODO
		}

		public void scale(int x, int y, int z) {
			// TODO
		}

	}
}