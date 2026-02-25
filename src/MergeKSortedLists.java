import java.util.*;

public class MergeKSortedLists {

    public static ArrayList<LinkedNode> mergeThreeSortedLists(
            ArrayList<LinkedNode> list1,
            ArrayList<LinkedNode> list2,
            ArrayList<LinkedNode> list3) {

        ArrayList<LinkedNode> result = new ArrayList<>();

        // PriorityQueue to store the current smallest node from each list
        // It stores an array: {nodeValue, listIndex, elementIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 1. Initialize the heap with the first element of each list (if not empty)
        if (!list1.isEmpty()) minHeap.add(new int[]{list1.get(0).data, 0, 0});
        if (!list2.isEmpty()) minHeap.add(new int[]{list2.get(0).data, 1, 0});
        if (!list3.isEmpty()) minHeap.add(new int[]{list3.get(0).data, 2, 0});

        ArrayList<ArrayList<LinkedNode>> allLists = new ArrayList<>(Arrays.asList(list1, list2, list3));

        // 2. Process the heap
        while (!minHeap.isEmpty()) {
            int[] smallest = minHeap.poll();
            int listIdx = smallest[1];
            int elementIdx = smallest[2];

            // Add the actual node to our result
            result.add(allLists.get(listIdx).get(elementIdx));

            // 3. Move to the next element in that specific list
            int nextElementIdx = elementIdx + 1;
            if (nextElementIdx < allLists.get(listIdx).size()) {
                minHeap.add(new int[]{
                        allLists.get(listIdx).get(nextElementIdx).data,
                        listIdx,
                        nextElementIdx
                });
            }
        }

        // 4. Final step: Relink the .next pointers
        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).next = result.get(i + 1);
        }
        if (!result.isEmpty()) result.get(result.size() - 1).next = null;

        return result;
    }

}
class LinkedNode {

    public int data;
    public LinkedNode next;
}
