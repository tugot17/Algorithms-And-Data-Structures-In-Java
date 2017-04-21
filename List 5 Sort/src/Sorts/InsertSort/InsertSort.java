package Sorts.InsertSort;

import Helpers.RandomGenerator;
import Helpers.Sort;
import Messages.SortMessage;
import Sorts.ISort;

/**
 * Created by pmazurek on 19.04.2017.
 */
public class InsertSort extends Sort implements ISort {

    //<editor-fold desc="Constructors">
    public InsertSort(int amountOfSortedElements) {
        super(amountOfSortedElements);
    }
    //</editor-fold>

    //<editor-fold desc="Public Methods">
    @Override
    public int[] sort() {
        array = RandomGenerator.createRandomArrayGenerator(amountOfSortedElements);

        return sort(array);
    }

    @Override
    public void sortLocally() {

        array = RandomGenerator.createRandomArrayGenerator(amountOfSortedElements);

        int[] helperArray = array;

        sort(helperArray);

    }

    @Override
    public int [] sort(int [] array) {

        int theBiggest;
        int helper;

        stoper.start();
        for (int i = array.length - 1; i > 0; i--) {
            theBiggest = 0;

            for (int j = 1; j <= i; j++) {
                if (array[j] > array[theBiggest]) {
                    theBiggest = j;
                }
                amountOfComparasions++;
            }

            if (theBiggest != i) {
                helper = array[theBiggest];
                array[theBiggest] = array[i];
                array[i] = helper;
            }

        }
        stoper.stop();

        SortMessage.showSortInformations("Insert", array.length, amountOfComparasions, stoper.getResult());


        return array;
    }
    //</editor-fold>

}