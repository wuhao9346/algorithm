package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.Node;
import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(CopyRandomList.NAME)
class CopyRandomListTest {
    private CopyRandomList instance;

    public static Stream<Node> params() {
        return Stream.of(
                buildRandomList(new Integer[][]{
                        new Integer[]{77, null},
                        new Integer[]{13, 0},
                        new Integer[]{11, 4},
                        new Integer[]{10, 2},
                        new Integer[]{1, 0}
                }),
                buildRandomList(new Integer[][]{
                        new Integer[]{1, 1},
                        new Integer[]{2, 1}
                }),
                buildRandomList(new Integer[][]{
                        new Integer[]{3, null},
                        new Integer[]{3, 0},
                        new Integer[]{3, null}
                })
        );
    }

    @BeforeEach
    void setUp() {
        instance = new CopyRandomList();
    }

    @DisplayName("迭代+节点拆分")
    @ParameterizedTest
    @MethodSource("params")
    void copyRandomList(Node head) {
        assertEquals(head, instance.copyRandomList(head));
    }

    @DisplayName("字典+回溯")
    @ParameterizedTest
    @MethodSource("params")
    void copyRandomListLookBack(Node head) {
        assertEquals(head, instance.copyRandomListLookBack(head));
    }

    private static boolean assertEquals(Node head, Node head1) {
        if (head == null && head1 == null) {
            return true;
        }
        if (head == null || head1 == null) {
            throw AssertionFailureBuilder.assertionFailure()
                    .expected(head)
                    .actual(head1)
                    .build();
        }
        if (head.random == null && head1.random == null) {
            return head.val == head1.val;
        }
        if (head.random == null || head1.random == null) {
            throw AssertionFailureBuilder.assertionFailure()
                    .expected(head.random)
                    .actual(head1.random)
                    .build();
        }
        if (head.random.val != head1.random.val) {
            throw AssertionFailureBuilder.assertionFailure()
                    .expected(head.random.val)
                    .actual(head1.random.val)
                    .build();
        }
        return assertEquals(head.next, head1.next);
    }

    private static Node buildRandomList(Integer[][] values) {
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i][0]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        for (int i = 0; i < values.length; i++) {
            Integer randomIndex = values[i][1];
            if (randomIndex != null) {
                nodes[i].random = nodes[randomIndex];
            }
        }
        return nodes[0];
    }
}