package com.shenxuan.springboot.collection.QueueBehavior;



import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(char primary,int secondary,String item){
           this.primary=primary;
           this.secondary=secondary;
           this.item=item;
        }
        @Override
        public int compareTo(ToDoItem arg) {
            if (primary >arg.primary){
                return +1;
            }
            if (primary==arg.primary){
                if (secondary>arg.secondary){
                    return +1;
                }else if (secondary==arg.secondary){
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary)+secondary+": "+item;
        }
    }
   public void add(String it,char pri,int sec){
       super.add(new ToDoItem(pri, sec, it));
   }

    public static void main(String[] args) {
        ToDoList toDoList=new ToDoList();
//        toDoList.add("");
    }
}
