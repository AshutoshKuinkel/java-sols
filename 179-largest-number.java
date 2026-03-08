class Solution{
    public String largestNumber(int[] nums){

        // conv to string arr
        String[] arr = new String[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        // check a + b vs b + a:
        Arrays.sort(arr,new Comparator<String>() {
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        // handle edge case{if 0 largest number in our sorted arr, just return 0}:
        if(arr[0].equals("0")){
            return "0";
        }

        // give the string output from sorted arr:
        StringBuilder output = new StringBuilder();
        for(String x: arr){
            output.append(x);
        }
        return output.toString();
    }
}
