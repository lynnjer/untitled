public class main13 {
    /**
     * 最长回文串
     * @param string string字符串
     * @return string字符串
     */
    public String longestPalindrom (String string) {
        int len= string.length();
        if (len<2){
            return string;
        }
        int max=1;
        String res=string.substring(0,1);
        for (int i=0;i<len-1;i++){
            String odd=center(string,i,i);
            String even=center(string,i,i+1);
            String maxlen=odd.length()>even.length()?odd:even;
            if (maxlen.length()>max){
                max=maxlen.length();
                res=maxlen;
            }
        }
        return res;
    }
    public String center(String s,int l,int r){
        int len=s.length();
        int i=l;
        int j=r;
        while (i>=0&&j<len){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else {
                break;
            }
        }
        return s.substring(i+1,j);
    }
    public int[] mergePrice (int[] a, int[] b) {
        int[] res=new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<a.length&&j<b.length){
            if (a[i]<=b[j]){
                res[k]=a[i];
                i++;
            }else {
                res[k]=b[j];
                j++;
            }
            k++;
        }
        if (i<a.length){
            while (i<a.length){
                res[k]=a[i];
                k++;
                i++;
            }
        }else {
            while (j<b.length){
                res[k]=b[j];
                k++;
                j++;
            }
        }
        return res;

    }
    public int tdepth (int[] arr) {
        int res=1;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]<arr[i+1]){
                res++;
            }
        }
        return res;
    }

}
