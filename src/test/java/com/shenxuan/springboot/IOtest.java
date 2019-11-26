package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.IO.Use.TextFile;
import com.shenxuan.springboot.Synchronized.Haha;
import com.shenxuan.springboot.bean.Beans;
import com.shenxuan.springboot.leetcode.No1122;
import com.shenxuan.springboot.leetcode.No1160;
import com.shenxuan.springboot.leetcode.No501;
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

    }
    @Test
    public void test3()throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(7);

        No501 no501 = new No501();
        no501.tset(list);
    }
}
