package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(WordDictionary.NAME)
class WordDictionaryTest {

    @Test
    void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad"));
        Assertions.assertTrue(wordDictionary.search("bad"));
        Assertions.assertTrue(wordDictionary.search(".ad"));
        Assertions.assertTrue(wordDictionary.search("b.."));
    }

    @Test
    void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("xgvk");
        wordDictionary.addWord("wykzbvwdsoyfowqicymzd");
        wordDictionary.addWord("xajbtjyjuwgoynjgu");
        Assertions.assertTrue(wordDictionary.search("wykzbvwdso..owqicymzd"));
        Assertions.assertFalse(wordDictionary.search("..ha"));
        wordDictionary.addWord("qsibzxaorktypkfg");
        Assertions.assertTrue(wordDictionary.search("xgvk"));
        wordDictionary.addWord("vbycuvrkbcq");
        Assertions.assertTrue(wordDictionary.search("qsibz.aorkty.kfg"));
        wordDictionary.addWord("sm");
        wordDictionary.addWord("fkqclfmvzpzpnbvz");
        Assertions.assertTrue(wordDictionary.search("vb..uvrkbcq"));
        wordDictionary.addWord("jpnneostllnnma");
        wordDictionary.addWord("zvmtfg");
        Assertions.assertFalse(wordDictionary.search("g.."));
        Assertions.assertTrue(wordDictionary.search(".kqclfmvzpzpnbvz"));
        wordDictionary.addWord("lboe");
        wordDictionary.addWord("jypzkxnzc");
        Assertions.assertFalse(wordDictionary.search("ii..mhdgrif"));
        Assertions.assertFalse(wordDictionary.search("ln."));
        Assertions.assertTrue(wordDictionary.search("zv..fg"));
        wordDictionary.addWord("qes");
        Assertions.assertFalse(wordDictionary.search("ittuggead.lxjey.i"));
        wordDictionary.addWord("jioqlytzqx");
        wordDictionary.addWord("fojsjyiz");
        Assertions.assertFalse(wordDictionary.search("a"));
        wordDictionary.addWord("qkprluekewtsftvbrjndpt");
        Assertions.assertFalse(wordDictionary.search("fkqlfmvzp.p.bvz"));
        wordDictionary.addWord("mwsgyywmmkzmy");
        Assertions.assertFalse(wordDictionary.search("g"));
        Assertions.assertTrue(wordDictionary.search(".pnneostllnnma"));
        Assertions.assertFalse(wordDictionary.search("bxwqn.nva.shpbb"));
        wordDictionary.addWord("tcjmitm");
        Assertions.assertTrue(wordDictionary.search("xajb.jyjuwgoynjg."));
        wordDictionary.addWord("pybk");
        Assertions.assertFalse(wordDictionary.search("qolrv"));
        Assertions.assertFalse(wordDictionary.search("qsibxa.rkty.kfg"));
        wordDictionary.addWord("poljqcitty");
        Assertions.assertFalse(wordDictionary.search("nmp"));
        Assertions.assertTrue(wordDictionary.search("lboe"));
        Assertions.assertFalse(wordDictionary.search("vm.f."));
        Assertions.assertFalse(wordDictionary.search("kurootufigiiy.v."));
        wordDictionary.addWord("qfdabgsvkboyaq");
        wordDictionary.addWord("pvreuprpvoycadnsxaajrkh");
        Assertions.assertFalse(wordDictionary.search("le.c.de"));
        Assertions.assertFalse(wordDictionary.search("jsxmeg.cnpigklxtyfcjset"));
        Assertions.assertTrue(wordDictionary.search("pybk"));
        wordDictionary.addWord("sv");
        wordDictionary.addWord("knmxzabetvqehv");
        Assertions.assertFalse(wordDictionary.search("ozh.zke.xy"));
        wordDictionary.addWord("ziazu");
        Assertions.assertFalse(wordDictionary.search("cfzvjmpidlvypukuvxf"));
        wordDictionary.addWord("ghhelrzgbsmxkrnezif");
        Assertions.assertFalse(wordDictionary.search("vqxn..aab"));
        Assertions.assertFalse(wordDictionary.search("xhyvayva."));
        Assertions.assertFalse(wordDictionary.search("xi"));
        wordDictionary.addWord("fn");
        wordDictionary.addWord("tnjcttrsozynjpqhox");
        wordDictionary.addWord("qhxcfujxmayzlsrctmsa");
        wordDictionary.addWord("fyaaivfrupktdgw");
        Assertions.assertTrue(wordDictionary.search("jpnne.stllnnma"));
        Assertions.assertTrue(wordDictionary.search(".."));
        Assertions.assertTrue(wordDictionary.search("zv..fg"));
        Assertions.assertFalse(wordDictionary.search("polq.it.y"));
    }
}