 🔷 Logic Chakra – Two Sum Problem  
 ✅ Approach 1: Brute Force  

📌 **Time Complexity:** O(n²)  
📌 **Space Complexity:** O(1)  
  


class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // For each element, check the rest of the array for a complement
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the sum of nums[i] and nums[j] equals the target
                if (nums[j] == target - nums[i]) {
                    // If found, return their indices
                    return new int[] { i, j };
                }
            }
        }
        // If no valid pair is found, return {-1, -1} to indicate failure
        return new int[] { -1, -1 };
    }
}


✅ Approach 2: Sorting + Two Pointer  (Binary Search)
📌 Time Complexity: O(n log n)  
📌 Space Complexity: O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store values and original indices
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }

        // Sort array based on values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;

        // Two pointer search
        while (left < right) {
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[] { arr[left][1], arr[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }
}

✅ Approach 3: Optimal (Using HashMap – Two Pass)  
📌 Time Complexity: O(n)  
📌 Space Complexity: O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // First pass: store value → index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Second pass: check for complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }

        return new int[] { -1, -1 };
    }
}


✅ Approach 4: Optimal (Using HashMap – One Pass)  
📌 Time Complexity: O(n)  
📌 Space Complexity: O(n)

  

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // One pass: check and store at the same time
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}

