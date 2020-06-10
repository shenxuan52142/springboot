package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.IO.Use.TextFile;
import com.shenxuan.springboot.Synchronized.Haha;
import com.shenxuan.springboot.bean.Beans;
import com.shenxuan.springboot.leetcode.*;
import com.shenxuan.springboot.tree.BinaaySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.shenxuan.springboot.IO.Use.BufferedInputFile.read;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Test
    public void test1()throws Exception{
        BinaaySearchTree<Integer> binaaySearchTree = new BinaaySearchTree<>();
        binaaySearchTree.insert(4);
        binaaySearchTree.insert(3);
        binaaySearchTree.insert(5);
        binaaySearchTree.insert(1);
        binaaySearchTree.insert(45);
        binaaySearchTree.insert(42);
        binaaySearchTree.insert(488);
        binaaySearchTree.insert(34);
        binaaySearchTree.insert(24);
        binaaySearchTree.insert(49);
        binaaySearchTree.insert(25);
        binaaySearchTree.insert(78);
        binaaySearchTree.insert(41);
binaaySearchTree.printTree();

    }
    @Test
    public void test2()throws Exception{
        No1122 no1122 = new No1122();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        no1122.relativeSortArray(arr1, arr2);
        float a=1111111111111111111111111.122222222222222222222222222222222222f;

    }
    @Test
    public void test3()throws Exception{
        ListNode a = new ListNode(5);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(8);
        a.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next = new ListNode(5);
        ListNode b = new ListNode(4);
        b.next = new ListNode(1);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(5);
        No160 no160 = new No160();
        no160.getIntersectionNode(b,a);
        System.out.println(a);
    }
    @Test
    public void test4() {
        No20 no20 = new No20();
        no20.isValid("()");
    }
}
