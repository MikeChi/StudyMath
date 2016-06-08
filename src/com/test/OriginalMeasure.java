package com.test;

public class OriginalMeasure {
	
	Node head = null ;  //链表头部 是第一个Node
	
	//增加节点
	public void addNode(int d){
		Node newNode = new Node(d); // 数据为d的新节点
		if(head == null){
			head = newNode ;
			return ;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next ;
		}
		temp.next = newNode ;
	}
	
	//删除节点
	public boolean deleteNode(int index){
		
		if(index < 1 || index > length()){
			return false;
		}
		
		if(index == 1){
			head =head.next ;
			return true ;
		}
		
		int i = 1 ;
		Node preNode = head ;
		Node curNode = preNode.next ;
		while(preNode.next != null){
			if(i == index){
				preNode.next =curNode.next ;
				curNode = null ;
				return true ;
			}
			preNode = curNode ;
			curNode = curNode.next ;
			i++ ;
		}
		return true ;
	}
	
	//节点长度
	public int length(){
		int length = 0;
		Node temp = head ;
		while(temp != null){
			length++;
			temp = temp.next ;
		}
		return length ;
	}
	
	/*
	 * 对链表进行排序
	 * 返回排序后的头结点
	 * 利用双节点
	 */
	public Node orderList(){
		Node nextNode = null ;
		int temp = 0 ;
		Node curNode = head ;
		while(curNode.next != null){
			nextNode = curNode.next ;
			
			while(nextNode != null){
				if(curNode.data > nextNode.data){
					temp = curNode.data ;
					curNode.data = nextNode.data ;
					nextNode.data = temp ;
				}
				nextNode = nextNode.next ;
			}
			curNode = curNode.next ;
			
		}
		return head ;
	}
	
	/*
	 * 打印链表
	 */
	public void printList(){
		//避免全局变量对方法体的影响
		Node temp = head ;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next ;
		}
	}
	
	public static void main(String [] args){
		OriginalMeasure list = new OriginalMeasure() ;
		list.addNode(5);
		list.addNode(3);
		list.addNode(3);
		list.addNode(1);
		System.out.println("listLen = "+list.length());
		System.out.println("before order");
		list.printList();
		list.orderList();
		System.out.println("after order");
		list.printList();
	}		

}
