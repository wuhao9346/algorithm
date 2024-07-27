package com.wuhao.algorithm.nowcoder;


import com.wuhao.algorithm.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CyclicShiftTree {
    public static final String NAME = "NC146 循环右移二叉树";

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param k    int整型
     * @return TreeNode类
     */
    public TreeNode cyclicShiftTree(TreeNode root, int k) {
        // write code here


        bfs(Collections.singletonList(root), k);
        return root;
    }

    private void bfs(List<TreeNode> parentNodeList, int k) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode parentNode : parentNodeList) {
            nodeList.add(parentNode.left);
            nodeList.add(parentNode.right);
        }

        if (nodeList.stream().allMatch(Objects::isNull)) {
            return;
        }

        bfs(nodeList.stream().filter(Objects::nonNull).collect(Collectors.toList()),
                k);

        int step = k % nodeList.size();
        if (step == 0) {
            return;
        }

        int index = nodeList.size() - step;
        for (int i = 0; i < nodeList.size(); i += 2) {
            parentNodeList.get(i / 2).left = nodeList.get((index++) % nodeList.size());
            parentNodeList.get(i / 2).right = nodeList.get((index++) % nodeList.size());
        }
    }
}
