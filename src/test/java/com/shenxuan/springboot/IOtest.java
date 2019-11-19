package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.IO.Use.TextFile;
import com.shenxuan.springboot.Synchronized.Haha;
import com.shenxuan.springboot.bean.Beans;
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
}
