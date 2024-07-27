package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(TreeNodeSerialize.NAME)
class TreeNodeSerializeTest {
    private final TreeNodeSerialize instance = new TreeNodeSerialize();

    public static Stream<TreeNode> params() {
        return Stream.of(
                TreeNode.buildTree(new Integer[]{1, 2, 3, null, null, 6, 7}),
                TreeNode.buildTree(new Integer[]{8, 6, 10, 5, 7, 9, 11})
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(TreeNode root) {
        String str = instance.Serialize(root);
        Assertions.assertEquals(root, instance.Deserialize(str));

    }
}