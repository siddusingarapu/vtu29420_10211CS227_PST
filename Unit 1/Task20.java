class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n =names.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(heights[i]<heights[j]){
                    int temp=heights[i];
                    heights[i]=heights[j];
                    heights[j]=temp;
                    String tempName= names[i];
                    names[i]=names[j];
                    names[j]=tempName;
                }
            }
        }
        return names;
    }
}

output
Input
names =
["Mary","John","Emma"]
heights =
[180,165,170]
Output
["Mary","Emma","John"]
Expected
["Mary","Emma","John"]
