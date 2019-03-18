import com.jogamp.opengl.*;
import java.util.*;

public abstract class Node3D {
	private Stack<Transform> tstack;
	private Node3D parent;
	public ArrayList<Node3D> children;
	
	public Node3D() {
		tstack = new Stack<Transform>();
		parent = null;
		children = null;
	}
	
	public Node3D(Node3D parent, Node3D[] children) {
		this.parent = parent;
		this.children = new ArrayList<Node3D>(Arrays.asList(children));
	}
	
	public void addChildNode(Node3D child) {
		
	}
	
	public abstract void draw(GL2 gl2);
	
	public abstract void getTransformRecursive();
	
	
	
}

class Transform{
	GL2 gl2;
	
	float[] matrix = new float[16];
	
	public Transform() {
	gl2 = null;	
	}
	
	public Transform(GL2 gl2) {
		this.gl2 = gl2;
	}
	
	public void translate(int x, int y, int z) {
		GL2 GLFloat;
	}
	
	public void rotate(float degrees, int x, int y, int z) {
		//TODO
	}
	
	public void scale(int x, int y, int z) {
		//TODO
	}
	
}