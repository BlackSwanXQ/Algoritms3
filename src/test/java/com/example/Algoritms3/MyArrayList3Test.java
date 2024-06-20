package com.example.Algoritms3;

import com.example.Algoritms3.exceptions.InvalidIndexException;
import com.example.Algoritms3.exceptions.NullItemException;
import com.example.Algoritms3.exceptions.StorageIsFullException;
import com.example.Algoritms3.MyArrayList3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayList3Test {
    private MyArrayList3 list = new MyArrayList3();

    Integer[] mas = new Integer[]{8, 4, 7, 9, 3};


    @BeforeEach
    void setUp() {
        for (Integer s : mas) {
            list.add(s);
        }
    }

    @AfterEach
    void tearDown() {
        list.clear();
    }

    @Test
    public void addElementTest() {
        Integer expected = 6;
        Integer actual = list.add(6);
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isEqualTo(list.get(5));
        assertThat(actual).isIn(list.toArray());
    }

    @Test
    void addElementIndexAndItemTest() {
        Integer expectedItem = 6;
        Integer actualItem = list.add(list.size(), 6);
        assertThat(actualItem).isEqualTo(expectedItem);
        Integer expected = 8888;
        Integer actual = list.add(2, 8888);
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isEqualTo(list.get(2));
        assertThat(actual).isIn(list.toArray());
    }

//    @Test
//    void addValidateSizeException() {
//        assertThatExceptionOfType(StorageIsFullException.class)
//                .isThrownBy(() -> {
//                    list.add(9999);
//                    list.add(0000);
//                    list.add(7777);
//                });
//    }

    @Test
    void addValidateNullItemException() {
        assertThatExceptionOfType(NullItemException.class)
                .isThrownBy(() -> {
                    list.add(null);
                });
    }

    @Test
    void addValidatevalidateIndexException() {
        assertThatExceptionOfType(InvalidIndexException.class)
                .isThrownBy(() -> list.add(6, 4444));
    }


    @Test
    void setElementTest() {
        assertThat(list.set(2, 4444)).isEqualTo(4444);
    }


    @Test
    void removeElementTest() {
        assertThat(list.remove(1)).isEqualTo(4);
        assertThat(list.remove(2)).isNotIn(7);
    }

    @Test
    void contains() {
        assertThat(list.contains(7)).isTrue();
    }

    @Test
    void indexOfElementTest() {
        assertThat(list.indexOf(7)).isEqualTo(2);
        assertThat(list.indexOf(10)).isEqualTo(-1);
    }

    @Test
    void lastIndexOfElementTest() {
        assertThat(list.lastIndexOf(4)).isEqualTo(1);
    }

    @Test
    void get() {
        assertThat(list.get(0)).isEqualTo(8);
    }

    @Test
    void testEquals() {
        assertThat(list.equals(list)).isTrue();
    }


    @Test
    void sizeDataTest() {
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void isEmptyTest() {
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    void clearTest() {
        list.clear();
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void toArrayTest() {
        assertThat(list.toArray()).isEqualTo(mas);
    }
}