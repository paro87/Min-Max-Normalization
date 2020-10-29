package NormalizationCalculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMaxNormalization {
    public static void main(String[] args) {
        populateSet();
    }

    public static void populateSet(){
        int belowBound=1;
        int upperBound=10_000;
        int setSize=10;
        int min=0;
        int max=0;
        List<BigDecimal> normalizationList = null;
        Set<Integer> numberSet=new HashSet<>();

        while (numberSet.size()!=setSize){
            int random = (int )(Math.random() * upperBound + belowBound);
            if (numberSet.add(random)){
                if (min==0 && max==0){
                    min=random;
                    max=random;
                    continue;
                }
                if(random<min){
                    min=random;
                } else if(random>max){
                    max=random;
                }
                normalizationList=calculateNormalization(numberSet, min, max);

            }
        }

        for (BigDecimal bigDecimal : normalizationList) {
            System.out.print(bigDecimal+" ");
        }

    }

    private static List<BigDecimal> calculateNormalization(Set<Integer> numberSet, int min, int max) {
        List<BigDecimal> normalizationList=new ArrayList<>();
        for (Integer number : numberSet) {
            double numerator=number-min;
            double denominator=max-min;
            BigDecimal normalization= BigDecimal.valueOf(numerator / denominator);
            normalizationList.add(normalization);
        }
        return normalizationList;
    }


}
