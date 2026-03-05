class Solution{
    public boolean searchMatrix(int[][]matrix, int target){
        
        int row = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = row * cols -1;

        while(left<=right){
            int mid = left + (right-left)/2;

            int midRow = mid/cols;
            int midCol = mid%cols;

            int midVal = matrix[midRow][midCol];

            if(midVal == target){
                return true;
            } else if (midVal < target){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}