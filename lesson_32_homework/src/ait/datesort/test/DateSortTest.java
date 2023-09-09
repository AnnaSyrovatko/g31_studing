package ait.datesort.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DateSortTest {

    Comparator<String> dateComparator;

    @BeforeEach
    void setUp() {
        dateComparator = (s1, s2) -> {

            int year = s1.substring(6).compareTo(s2.substring(6));
            int month = s1.substring(3,5).compareTo(s2.substring(3,5));
            int day = s1.substring(0,2).compareTo(s2.substring(0,2));

//            String [] str1 = s1.split("-");
//            String [] str2 = s2.split("-");
//            int day = str1[0].compareTo(str2[0]); etc

            if (year != 0) {
                return year;
            } else if (month != 0) {
                return month;
            } else {
                return day;
            }
        };
    }

        @Test
        void testDateSort() {
            String[] dates = {
                    "07-05-1990",
                    "28-01-2010",
                    "11-08-1990",
                    "15-01-2010",
                    "16-06-1970"
            };
            String[] expected = {
                    "16-06-1970",
                    "07-05-1990",
                    "11-08-1990",
                    "15-01-2010",
                    "28-01-2010"
            };
            Arrays.sort(dates, dateComparator);
//            System.out.println(Arrays.toString(dates));
            assertArrayEquals(expected, dates);
        }

    }

