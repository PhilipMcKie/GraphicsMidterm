import com.jogamp.opengl.*;

public class SceneGraph {
	private Node3D root;
	private GL2 gl2;
	
	public SceneGraph()
	{
		root = null;
		gl2 = null;
	}
	
	public SceneGraph(GL2 gl2) {
		root = null;
		this.gl2 = gl2;
	}
	
	public void Traversal(Node3D node)
	{
		if (node == null)
			return;
		
		for(int i = 0; i< node.children.size(); i++)
		{
			Traversal(node.children.get(i));
			node.draw(gl2);
			
		}
	}
	
	public void Traversal()
	{
		Traversal(root);
	}
	
	public void Rotate(float angle, float x, float y, float z)
	{
		gl2.glRotatef(angle, x, y, z);
	}
	
	public void Scale(float x, float y, float z)
	{
		gl2.glScalef(x, y, z);
	}
	
	public void Translate(float x, float y, float z)
	{
		gl2.glTranslatef(x, y, z);
	}
	
	public void LoadIdentity()
	{
		gl2.glLoadIdentity();
	}
}
