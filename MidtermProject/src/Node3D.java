import com.jogamp.opengl.*;
import java.util.*;

public abstract class Node3D {
	private Stack<Transform> tstack;
	private Node3D parent;
	private ArrayList<Node3D> children;
	
	public Node3D() {
		tstack = new Stack<Transform>();
		parent = null;
		children = null;
	}
	
	public Node3D(Node3D parent, Node3D[] children) {
		this.parent = parent;
		this.children = new ArrayList<Node3D>(Arrays.asList(children));
	}
	
	
	public abstract void draw(GL2 gl2);
	
	public abstract void getTransformRecursive();
	
	
	
}

class Transform{
	
}