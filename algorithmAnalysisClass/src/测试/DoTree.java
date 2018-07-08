package 测试;

public class DoTree {
	int data;
	public DoTree left;
	public DoTree right;
	
	DoTree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	DoTree(int data,DoTree l,DoTree r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public DoTree getLeft() {
		return left;
	}


	public void setLeft(DoTree left) {
		this.left = left;
	}


	public DoTree getRight() {
		return right;
	}


	public void setRight(DoTree right) {
		this.right = right;
	}
	
	//先序遍历,顺着中左右的顺序
	public static void PreTraversal(DoTree dt){
		System.out.println(dt.getData());
		if(dt.getLeft()!=null){
			PreTraversal(dt.getLeft());
		}
		if(dt.getRight()!=null){
			PreTraversal(dt.getRight());
		}
	}

	//中序遍历，左中右
	public static void MidTraversal(DoTree dt){
		if(dt.getLeft()!=null){
			MidTraversal(dt.getLeft());
		}
		System.out.println(dt.getData());
		if(dt.getRight()!=null){
			MidTraversal(dt.getRight());
		}
	}
	
	//将二叉树变为双向链表
	public static void convert(DoTree root,DoTree l,DoTree r){
		//System.out.println(root.getData());
		if(root.getLeft()  == null){
			l.setRight(root);
			root.setLeft(l);///////////////
		}{
			convert(root.left,l,root);
		}
		if(root.getRight() == null){
			r.setLeft(root);
			root.setRight(r);
		}{
			convert(root.right,root,r);
		}
	}
	
	
	//将二叉树变为双向链表
	public static DoTree convert2(DoTree root,boolean isRight){
		if(root == null)
			return null;
		DoTree turnback = isRight? MostLeft(root):MostRight(root);
		if(root.left!=null){
			root.left = convert2(root.left,false);
			root.left.right = root;
		}
		
		if(root.right!=null){
			root.right = convert2(root.right,true);
			root.right.left = root;
		}			
		return turnback;
		
	}	
	public static DoTree MostLeft(DoTree root){
		DoTree temp = root;
		while(temp.getLeft()!=null)
			temp = temp.left;
		return temp;
	}
	public static DoTree MostRight(DoTree root){
		DoTree temp = root;
		while(temp.getRight()!=null)
			temp = temp.right;
		return temp;
	}
	
	public static void main(String[] args){
		DoTree dt1 = new DoTree(1);
		DoTree dt3 = new DoTree(3);
		DoTree dt11 = new DoTree(11);
		DoTree dt6 = new DoTree(6);
		DoTree dt2 = new DoTree(2,dt1,dt3);
		DoTree dt5 = new DoTree(5,dt2,dt6);
		DoTree dt9 = new DoTree(9,null,dt11);
		DoTree dt8 = new DoTree(8,null,dt9);
		DoTree dt7 = new DoTree(7,dt5,dt8);
		//DoTree.PreTraversal(dt7);
		//DoTree.MidTraversal(dt7);
		DoTree dd = convert2(dt7,true);//如果是true，返回值为最小的节点
//		DoTree l = new DoTree(111111);
//		DoTree r = new DoTree(222222);
//		DoTree.convert(dt7,l,r);
//		l.right.left = null;
//		r.left.right = null;
		while(dd.right!=null){
			System.out.println(dd.right.data);
			dd = dd.right;
		}
	}
	
}
