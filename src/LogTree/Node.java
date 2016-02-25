package logtree;  
  
public class Node<T> {  
    private T data;  
    private int parent;
    private int depth;
      
    public Node(){  
    }  
      
    public Node(T data){  
        this.data = data;  
    }  
      
    public Node(T data,int parent,int depth){  
        this.data = data;  
        this.parent = parent;
        this.depth = depth;
    }  
      
    public void setData(T data){  
        this.data = data;  
    }  
      
    public T getData(){  
        return this.data;  
    }  
      
    public void setParent(int parent){  
        this.parent = parent;  
    }  
      
    public int getParent(){  
        return this.parent;  
    }
    
    public void setDepth(int depth){  
        this.depth = depth;  
    }
    
    public int getDepth(){  
        return this.depth;  
    }
}  