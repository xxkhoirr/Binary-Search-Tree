package praktikum4;

import java.util.ArrayList;
import java.util.Scanner;
//kelompok :
//1. Khoirunnisa
//2. M Nibrassuddin A Z
//3. M Reza Abidin
//4. M Bin Idrus (tidak aktif)

class titik {          
	ArrayList<String>data;
	int key;
	titik left, right;
	titik(int key){
		this.data = new ArrayList<String>();
		this.key=key;
		left = right =null;
	}
}

class BST {
	titik root;

	void insert(String string) {
		root = insertRec(root,string); 
	}
	
	int convert (String a) {
		int jum=0;
		char[] karakter = a.toCharArray();
        for(int i = 0; i < karakter.length ;i++) {
        	jum=jum+karakter[i];
        }
        return jum;
	}
	
	titik insertRec(titik current, String string) {
		if(current==null) {
			current=new titik(convert(string));
			current.data.add(string);
		}else if(current.key < convert(string)) {
			current.right=insertRec(current.right,string);
		}else if(current.key > convert(string)) {
			current.left=insertRec(current.left,string);
		} else {
			current.data.add(string);
		}
		return current;
	}
	
	void preOrder(titik current) {
		if(current!=null) {
			System.out.println(current.key + ">" + current.data);
			preOrder(current.left);
			preOrder(current.right);
		}
	}
		
	boolean search(String string) {
		return searchRec(root,string); 
	}
	
	boolean searchRec(titik current, String string) { 
		if(current==null) {
			return false;
		} else if(current.key < convert(string)) {
			return searchRec(current.right,string);
		} else if(current.key > convert(string)) {
			return searchRec(current.left,string);
		} else {
			return current.data.contains(string);
		}
	}
}

public class tugas_BST{
	
	public static void main(String[] args) {
		BST a=new BST();
		System.out.println("Daftar nama:");
		a.insert("galih");
		a.insert("hakikid");
		a.insert("handy");
		a.insert("ydnah");
		a.preOrder(a.root);
		System.out.println(" ");
		System.out.println("mencari 'handy' pada daftar nama  	->" + a.search("handy"));
		System.out.println("mencari 'galih' pada daftar nama 	->" + a.search("galih"));
		System.out.println("mencari 'fauzivy' pada daftar nama 	->" + a.search("fauzivy"));
		System.out.println("mencari 'ydnah' pada daftar nama 	->" + a.search("ydnah"));
		System.out.println("mencari 'hadny' pada daftar nama  	->" + a.search("hadny"));
	}
}