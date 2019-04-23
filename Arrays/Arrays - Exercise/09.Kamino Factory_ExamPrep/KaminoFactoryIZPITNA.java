import java.util.Scanner;

public class KaminoFactoryIZPITNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String input = "";

        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int bestSequenceIndexRow = 0;
        int bestSequenceIndexRowOutput = 0;
        String sequenceOutput = "";

        while (!"Clone them!".equals(input = scanner.nextLine())) {
            ++bestSequenceIndexRow;
            String[] data = input.split("!+");
            int[] sequenceDNA = new int[size];
            int index = 0;
            for (int i = 0; i <data.length ; i++) {
                sequenceDNA[index++] = Integer.parseInt(data[i]);
            }

            int maxCount = 0;
            int sequenceIndex = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                int currentCount = 0;
                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == sequenceDNA[j]){
                        currentCount++;
                        if (currentCount>maxCount){
                            maxCount = currentCount;
                            sequenceIndex = i;
                        }
                    }else{
                        break;
                    }
                }
            }
            int sequenceSum = 0;
            for (int i = 0; i <sequenceDNA.length ; i++) {
                if (sequenceDNA[i] ==1){
                    sequenceSum += sequenceDNA[i];
                }
            }
            if (sequenceIndex < bestSequenceIndex || sequenceSum > bestSequenceSum){
                sequenceOutput = "";
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestSequenceIndexRowOutput = bestSequenceIndexRow;
                for (int i = 0; i < sequenceDNA.length; i++) {
                    sequenceOutput += sequenceDNA[i] + " ";
                }
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSequenceIndexRowOutput,bestSequenceSum);
        System.out.println(sequenceOutput);
    }
}