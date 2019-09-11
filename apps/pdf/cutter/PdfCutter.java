package pdf.cutter;

import java.util.*;

public class PdfCutterMain {
    private static class PdfCutter{
        /**
         * @param totalPage 输入总页数
         * @param pages 想要的页数
         * @return 输出 切割的节点
         */
        public  Vector<Integer>  cut(int totalPage, Vector<Integer> pages) {
            pages = deDuplicate(pages);
            Collections.sort(pages);
//            return ;
            return null;
        }

        private Vector<Integer> deDuplicate(Vector<Integer> pages) {
            int size = pages.size();
            Map<Integer, Object> map = new LinkedHashMap<Integer, Object>(size);
            Object o = new Object();
            Vector finalList = new Vector(size);
            for (Integer page : pages) {
                Object o1 = map.get(page);
                if (o1 == null) {
                    map.put(page, o);
                    finalList.add(page);
                }
            }
            return finalList;
        }
    }
    public static void main(String[] args) {

    }
}

